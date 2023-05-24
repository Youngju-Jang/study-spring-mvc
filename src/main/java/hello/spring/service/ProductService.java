package hello.spring.service;

import hello.spring.dto.ProductDto;

import java.util.List;

public interface ProductService {
     public void productInsert(ProductDto productDto);
     public List<ProductDto> selectAll();
}
