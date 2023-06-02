package hello.spring.service;

import hello.spring.dto.ProductResponseDto;
import hello.spring.entity.Cart;
import hello.spring.entity.Product;

import java.util.List;
import java.util.Set;

public interface CartService {
     List<Cart> selectAllByNoSet(Set<Integer> newCartSet);
     
}
