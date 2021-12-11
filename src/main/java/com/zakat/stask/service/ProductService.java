package com.zakat.stask.service;

import com.zakat.stask.entity.Product;
import com.zakat.stask.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService implements ProductServiceInterface {

    @Autowired
private ProductRepository productRepository;

    @Override
    @Transactional
    public List<Product> getAllProduct() {
        return productRepository.getAllProduct();
    }

    @Override
    @Transactional
    public void saveProduct(Product product) {

        productRepository.saveProduct(product);
    }

    @Override
    @Transactional
    public Product getProduct(Long id) {
Product prod = productRepository.getProduct(id);
    return prod;
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
productRepository.deleteProduct(id);
    }


}
