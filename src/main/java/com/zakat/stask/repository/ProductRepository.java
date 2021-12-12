package com.zakat.stask.repository;

import com.zakat.stask.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


   public List<Product> findProductsByNameAndLanguageMapNotNull(String name);

    public List<Product> findProductsByLanguageMapIsNotNull();

    public Product findByIdAndLanguageMapIsNotNull(Long id);

}
