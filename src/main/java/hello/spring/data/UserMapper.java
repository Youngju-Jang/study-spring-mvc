package hello.spring.data;

import hello.spring.entity.User;

public interface UserMapper {
     User selectUser(String name);
}
