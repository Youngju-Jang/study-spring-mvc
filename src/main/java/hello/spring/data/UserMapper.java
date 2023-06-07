package hello.spring.data;

import hello.spring.entity.User;

public interface UserMapper {
     boolean isExist(String name);
     User selectByName(String name);
     void createUser(User user);
}
