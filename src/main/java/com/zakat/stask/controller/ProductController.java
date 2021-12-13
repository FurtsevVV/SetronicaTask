package com.zakat.stask.controller;

import com.zakat.stask.entity.Product;
import com.zakat.stask.model.ProductModel;
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


    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public List<Product> getAllProduct() {
        List<Product> productList = productService.getAllProduct();
        return productList;
    }

    //get product by Id. If Id not exist return page with status 404
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product product = productService.getProduct(id);
        HttpStatus status = product != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Product>(product, status);
    }

    //save to database new ProductModel with validation field name, price,
    // dateOfCreation(pattern), dateOfModification(pattern)
    //string field Language checked in ProductService with map from
    //table 'languagemap'. If language value exist - save new object
    //if value wrong - save new object with value Language/Currency = null
    @PostMapping("/products")
    public ResponseEntity addNewProduct(@Valid @RequestBody ProductModel product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Ошибка валидации");
        }
       String message = productService.saveProduct(product);
        return ResponseEntity.ok(message);
    }

    //update existing ProductModel(!) with validation
    //string field Language checked in ProductService with map from
    //table 'languagemap'. If language value exist - save new object
    //if value wrong - save new object with value Language/Currency = null
    @PutMapping("/products")
    public ResponseEntity updateProduct(@Valid @RequestBody ProductModel product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Ошибка валидации");
        }
        System.out.printf(product.toString());
       String message = productService.saveProduct(product);
        return ResponseEntity.ok(message);
    }

    //delete entity by id
    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "Product with id = " + id + " was deleted";
    }


}
