package hello.spring.dao;

import hello.spring.entity.Product;

import java.util.HashMap;
import java.util.List;

public interface ProductDao {
     public void productInsert(Product product);
     List<Product> selectAll(HashMap<String, Object> hashMap);
     int countAll();
}
