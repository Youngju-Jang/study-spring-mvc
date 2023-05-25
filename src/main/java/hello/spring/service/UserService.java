package hello.spring.service;

import hello.spring.entity.User;

public interface UserService {
     boolean isExist(String name);
     User selectByName(String name);
}
