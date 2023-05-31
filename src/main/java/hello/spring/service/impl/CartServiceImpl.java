package hello.spring.service.impl;

import hello.spring.dao.CartDao;
import hello.spring.dto.ProductResponseDto;
import hello.spring.entity.Product;
import hello.spring.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
     private final CartDao cartDao;
     
     @Override
     public List<ProductResponseDto> selectAllByNoSet(Set<Integer> newCartSet) {
          List<Product> productList = cartDao.selectAllByNoSet(newCartSet);
          if (productList == null) {
               return null;
          }
          return productList.stream().map(ProductResponseDto::entity2Dto)
               .collect(Collectors.toList());
     }
}
