package hello.spring.dao.impl;

import hello.spring.dao.ProductDao;
import hello.spring.model.Product;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductDaoImpl implements ProductDao {
     
     private final SqlSessionTemplate sqlSession;
     
     @Override
     @Transactional
     public void productInsert(Product product) {
     
     }
     
     @Override
     public List<Product> selectAll() {
          return null;
     }
}
