package com.zakat.stask.controller;


import com.zakat.stask.entity.Product;
import com.zakat.stask.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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


    @GetMapping("/name/{name}")
    public ResponseEntity<List<Product>>findProductByName(@PathVariable String name){
             List<Product> productList = productService.getProductsByName(name);
        HttpStatus status = productList != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST;

        return new ResponseEntity<List<Product>>(productList, status);
    }

    @GetMapping("/")
    public List<Product> getAllProduct(){
        List<Product> productList = productService.getAllProductWithLanguageAndCurrency();
        return productList;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Product>findProductById(@PathVariable Long id){
        Product product = productService.getProductsById(id);
        HttpStatus status = product != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST;

        return new ResponseEntity<Product>(product, status);
    }


}
