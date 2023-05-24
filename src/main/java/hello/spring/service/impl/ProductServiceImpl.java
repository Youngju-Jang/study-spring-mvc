package hello.spring.service.impl;

import hello.spring.dao.ProductDao;
import hello.spring.dto.ProductDto;
import hello.spring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
     
     private final ProductDao productDao;
     @Override
     public void productInsert(ProductDto productDto) {
     
     }
     @Override
     public List<ProductDto> selectAll() {
          return null;
     }
}
