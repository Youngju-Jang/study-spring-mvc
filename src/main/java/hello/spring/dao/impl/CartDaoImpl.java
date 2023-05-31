package hello.spring.dao.impl;

import hello.spring.dao.CartDao;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CartDaoImpl implements CartDao {
     private final SqlSessionTemplate sqlSession;
     
}
