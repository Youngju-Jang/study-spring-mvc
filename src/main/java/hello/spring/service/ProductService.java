package hello.spring.service;

import hello.spring.dto.ProductResponseDto;

import java.util.HashMap;
import java.util.List;

public interface ProductService {
     public void productInsert(ProductResponseDto productResponseDto);
     public List<ProductResponseDto> selectAll(HashMap<String, Object> hashMap);
     int countAll();
}
