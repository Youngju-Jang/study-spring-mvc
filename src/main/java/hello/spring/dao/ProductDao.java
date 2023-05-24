package hello.spring.dao;

import hello.spring.model.Product;

import java.util.List;

public interface ProductDao {
     public void productInsert(Product product);
     List<Product> selectAll();
}
