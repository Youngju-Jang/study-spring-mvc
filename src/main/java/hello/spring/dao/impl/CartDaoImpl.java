package hello.spring.dao.impl;

import hello.spring.dao.CartDao;
import hello.spring.data.CartMapper;
import hello.spring.entity.Cart;
import hello.spring.entity.Product;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
@RequiredArgsConstructor
public class CartDaoImpl implements CartDao {
     private final SqlSessionTemplate sqlSession;
     
     @Override
     public List<Product> selectAllByNoList(Set<Integer> newCartNoSet) {
          List<Product> productList = null;
          CartMapper mapper = sqlSession.getMapper(CartMapper.class);
          productList = mapper.selectAllByNoSet(newCartNoSet);
          return productList;
     }
}
