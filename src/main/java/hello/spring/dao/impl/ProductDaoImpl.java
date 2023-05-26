package hello.spring.dao.impl;

import hello.spring.dao.ProductDao;
import hello.spring.data.ProductMapper;
import hello.spring.entity.Product;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductDaoImpl implements ProductDao {
     
     private final SqlSessionTemplate sqlSession;
     
     @Override
     @Transactional
     public void productInsert(Product product) {
          ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
          productMapper.productInsert(product);
     }
     
     @Override
     public List<Product> selectAll(HashMap<String, Object> hashMap) {
          List<Product> productList = null;
          ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
          productList = productMapper.selectAll(hashMap);
          return productList;
     }
     
     @Override
     public int countAll() {
          ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
          return productMapper.countAll();
     }
}
