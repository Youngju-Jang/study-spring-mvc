package hello.spring.service;

import hello.spring.dto.ProductRequestDto;
import hello.spring.dto.ProductResponseDto;
import hello.spring.entity.Product;
import hello.spring.entity.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface ProductService {
     public void productInsert(ProductRequestDto productRequestDto, User user) throws IOException;
     public List<ProductResponseDto> selectAll(HashMap<String, Object> hashMap);
     int countAll(String search, String option);
     public void productEdit(ProductRequestDto productRequestDto, Integer no);
     public void deleteById(Integer no);
}
