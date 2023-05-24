package hello.spring.data;

import hello.spring.entity.Product;

import java.util.HashMap;
import java.util.List;

public interface ProductMapper {
     int countAll();
     List<Product> selectAll(HashMap<String, Object> hashMap);
}
