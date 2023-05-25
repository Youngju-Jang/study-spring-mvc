package hello.spring.service.impl;

import hello.spring.dao.UserDao;
import hello.spring.entity.User;
import hello.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
     private final UserDao userDao;
     
     @Override
     public boolean isExist(String name) {
          return userDao.isExist(name);
     }
     
     @Override
     public User selectByName(String name) {
          return userDao.selectByName(name);
     }
}
