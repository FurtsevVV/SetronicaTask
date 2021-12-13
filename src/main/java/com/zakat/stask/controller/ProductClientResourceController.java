package com.zakat.stask.controller;


import com.zakat.stask.entity.Product;
import com.zakat.stask.exception.ProductNotFoundException;
import com.zakat.stask.exception.ProductNotFoundObj;
import com.zakat.stask.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.FileReader;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ProductClientResourceController {

    final static Logger logger = Logger.getLogger(FileReader.class);

    @Autowired
    private ProductService productService;

    //return list of products by name from database except products
    //without defined language and currency
    //or throw exception and error object
    //log exception on file
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Product>> findProductByName(@PathVariable String name) {
        List<Product> productList = productService.getProductsByName(name);
        HttpStatus status = productList != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        if (productList.size() == 0) {
            logger.error("Logger: No Product with name=" + name + " in database, or currency and language this product not defined");
            throw new ProductNotFoundException("No Product with name=" + name + " in database, or currency and language this product not defined");
        }
        return new ResponseEntity<List<Product>>(productList, status);
    }

    //return all products except products without defined language and currency with pagination
    @GetMapping("/")
    public Page<Product> getAllProduct(@PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable, PagedResourcesAssembler assembler) {
        pageable = PageRequest.of(0, 10);

        Page<Product> productList = productService.getAllProductWithLanguageAndCurrency(pageable);
        return productList;
    }

    //return product by id if defined language and currency
    //or throw exception and error object
    //log exception on file
    @GetMapping("/id/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        Product product = productService.getProductsById(id);
        HttpStatus status = product != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        if (product == null) {
            logger.error("Logger: No Product with id=" + id + " in database, or currency and language this product not defined");
            throw new ProductNotFoundException("No Product with id=" + id + " in database, or currency and language this product not defined");
        }
        return new ResponseEntity<Product>(product, status);
    }

    @ExceptionHandler
    public ResponseEntity<ProductNotFoundObj> handlerException(ProductNotFoundException exception) {
        ProductNotFoundObj productNotFoundObj = new ProductNotFoundObj();
        productNotFoundObj.setErrorMessage(exception.getMessage());
        productNotFoundObj.setErrorCode("Status 404");
        return new ResponseEntity<>(productNotFoundObj, HttpStatus.NOT_FOUND);

    }

}
