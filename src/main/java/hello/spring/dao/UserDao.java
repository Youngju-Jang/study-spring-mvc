package hello.spring.dao;

import hello.spring.entity.User;

public interface UserDao {
     boolean isExist(String name);
     User selectByName(String name);
}
