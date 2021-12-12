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
@RequestMapping("/api")
public class ProductController {

    final static Logger logger = Logger.getLogger(FileReader.class);

    @Autowired
    private ProductService productService;



    @GetMapping("/products")
    public List<Product> getAllProduct(){
   List<Product> productList = productService.getAllProduct();
   return productList;
    }

    //get product by Id. If Id not exist return empty page with status 404

    @GetMapping("/products/{id}")
public ResponseEntity<Product> getProduct(@PathVariable Long id){
        Product product = productService.getProduct(id);
        HttpStatus status = product != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;

        return new ResponseEntity<Product>(product, status);
    }

    @PostMapping("/products")

    public ResponseEntity addNewProduct(@Valid @RequestBody Product product, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
        return ResponseEntity.badRequest().body("Ошибка валидации");
        }
        productService.saveProduct(product);
return ResponseEntity.ok("New product saved");
    }


    @PutMapping("/products")
public ResponseEntity updateProduct(@Valid@RequestBody Product product, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Ошибка валидации");
        }
        productService.saveProduct(product);
        return ResponseEntity.ok("Product update");
    }

    @DeleteMapping("/products/{id}")
public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "Product with id = " + id + " was deleted";
    }





}
