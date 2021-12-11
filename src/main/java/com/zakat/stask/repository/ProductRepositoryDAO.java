package com.zakat.stask.repository;

import com.zakat.stask.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProductRepositoryDAO implements ProductRepository {

    @Autowired
private EntityManager entityManager;

    @Override
    public List<Product> getAllProduct() {
       Query query = entityManager.createQuery("from Product");
        List<Product> list = query.getResultList();

return list;
    }

    @Override
    public void saveProduct(Product product) {

        entityManager.merge(product);
    }

    @Override
    public Product getProduct(Long id) {

Product product = entityManager.find(Product.class, id);
return product;
    }

    @Override
    public void deleteProduct(Long id) {

Query query = entityManager.createQuery("delete from Product where id =:productId" );
query.setParameter("productId", id);
query.executeUpdate();
    }
}
