package com.zakat.stask.service;

import com.zakat.stask.entity.Product;
import com.zakat.stask.model.ProductModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductServiceInterface {

    public List<Product> getAllProduct();

    public String saveProduct(ProductModel product);

    public Product getProduct(Long id);

    public void deleteProduct(Long id);

    public List<Product> getProductsByName(String name);

    public Page<Product> getAllProductWithLanguageAndCurrency(Pageable pageable);

    public Product getProductsById(Long id);
}
