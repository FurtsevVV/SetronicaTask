package com.zakat.stask.repository;

import com.zakat.stask.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository  {


 public    List<Product> getAllProduct();

 public void saveProduct(Product product);

 public Product getProduct(Long id);
 public void deleteProduct(Long id);
}
