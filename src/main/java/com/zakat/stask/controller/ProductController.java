package com.zakat.stask.controller;

import com.zakat.stask.entity.Product;
import com.zakat.stask.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    final static Logger logger = Logger.getLogger(FileReader.class);

    @Autowired
    private ProductService productService;

//    @GetMapping
//public ResponseEntity getProduct(){
//    try{
//        logger.info("Server work");
//
//        return ResponseEntity.ok("Server Workong");
//    } catch (Exception e){
//        logger.error("Error request in method getProduct");
//
//        return ResponseEntity.badRequest().body("Error Request");
//
//    }
//}

    @GetMapping("/products")
    public List<Product> getAllProduct(){
   List<Product> productList = productService.getAllProduct();
   return productList;
    }

    @GetMapping("/products/{id}")
public Product getProduct(@PathVariable Long id){
        Product product = productService.getProduct(id);
        return product;
    }

    @PostMapping("/products")
    public Product addNewProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return product;
    }

    @PutMapping("/products")
public Product updateProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return product;
    }

    @DeleteMapping("/products/{id}")
public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "Product with id = " + id + " was deleted";
    }


//    @GetMapping
//    public ResponseEntity getOneUser(@RequestParam Long id) {
//        try {
//            return ResponseEntity.ok(userService.getOne(id));
//        } catch (UserNotFoundException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Произошла ошибка");
//        }
//    }


}
