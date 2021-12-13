package com.zakat.stask.service;

import com.zakat.stask.entity.CurrencyLanguageMap;
import com.zakat.stask.entity.Product;
import com.zakat.stask.model.ProductModel;
import com.zakat.stask.repository.LanguageRepository;
import com.zakat.stask.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceInterface {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public String saveProduct(ProductModel product) {
        String chekedLanguageValue = product.getLanguage();
        CurrencyLanguageMap languageMap = languageRepository.findByLanguage(chekedLanguageValue);
        Product savedProduct = new Product();
        savedProduct.setId(product.getId());
        savedProduct.setName(product.getName());
        savedProduct.setDescription(product.getDescription());
        savedProduct.setDateOfCreation(product.getDateOfCreation());
        savedProduct.setDateOfModification(product.getDateOfModification());
        savedProduct.setPrice(product.getPrice());
        savedProduct.setLanguageMap(languageMap);

       productRepository.save(savedProduct);
       if(languageMap==null)
           return "Product saved with Value currency and language = null. Wrong value to model";
       else
           return "Product saved successuly";
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
