package hello.spring.dao;

import hello.spring.entity.Cart;
import hello.spring.entity.Product;

import java.util.List;
import java.util.Set;

public interface CartDao {
     List<Product> selectAllByNoList(Set<Integer> newCartSet);
}
