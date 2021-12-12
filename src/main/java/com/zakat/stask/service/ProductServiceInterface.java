package com.zakat.stask.service;

import com.zakat.stask.entity.Product;

import java.util.List;

public interface ProductServiceInterface {

   public List<Product> getAllProduct();

   public void saveProduct(Product product);

   public Product getProduct(Long id);

   public void deleteProduct(Long id);

   public List<Product> getProductsByName(String name);

  public List<Product> getAllProductWithLanguageAndCurrency();

   public Product getProductsById(Long id);
}
