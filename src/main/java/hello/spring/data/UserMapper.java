package hello.spring.data;

import hello.spring.model.User;

public interface UserMapper {
     User selectUser(String name);
}
