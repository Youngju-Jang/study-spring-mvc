package hello.spring.dao.impl;

import hello.spring.dao.UserDao;
import hello.spring.data.UserMapper;
import hello.spring.entity.User;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {
     
     private final SqlSessionTemplate sqlSession;
     @Override // 동일아이디 존재여부
     public boolean isExist(String name) {
          boolean exist = false;
          UserMapper productMapper = sqlSession.getMapper(UserMapper.class);
          exist = productMapper.isExist(name);
          return exist;
     }
     
     @Override
     public User selectByName(String name) {
          User user = null;
          UserMapper productMapper = sqlSession.getMapper(UserMapper.class);
          user = productMapper.selectByName(name);
          return user;
     }
}
