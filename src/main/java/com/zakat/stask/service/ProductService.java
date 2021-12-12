package com.zakat.stask.service;

import com.zakat.stask.entity.Product;
import com.zakat.stask.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceInterface {

    @Autowired
    private ProductRepository productRepository;

    @Override

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override

    public void saveProduct(Product product) {

        productRepository.save(product);
    }

    @Override

    public Product getProduct(Long id) {
        Product prod = null;
        Optional<Product> opt = productRepository.findById(id);
        if (opt.isPresent()) {
            prod = opt.get();
        }
        return prod;
    }

    @Override

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepository.findProductsByNameAndLanguageMapNotNull(name);

    }

    @Override
    public Page<Product> getAllProductWithLanguageAndCurrency(Pageable pageable) {
        return productRepository.findProductsByLanguageMapIsNotNull(pageable);
    }

    @Override
    public Product getProductsById(Long id) {
        return productRepository.findByIdAndLanguageMapIsNotNull(id);
    }


}
