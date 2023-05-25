package hello.spring.service.impl;

import hello.spring.dao.ProductDao;
import hello.spring.dto.ProductResponseDto;
import hello.spring.entity.Product;
import hello.spring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
     
     private final ProductDao productDao;
     @Override
     public void productInsert(ProductResponseDto productResponseDto) {
     
     }
     @Override
     public List<ProductResponseDto> selectAll(HashMap<String, Object> hashMap) {
          List<Product> productList = productDao.selectAll(hashMap);
          if(productList == null){
               return null;
          }
          return productList.stream().map(ProductResponseDto::entity2Dto).collect(Collectors.toList());
     }
     
     @Override
     public int countAll() {
          return productDao.countAll();
     }
}
