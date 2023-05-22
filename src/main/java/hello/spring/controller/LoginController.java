package hello.spring.controller;

import hello.spring.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController {
     @GetMapping("/login")
     public String message(){
          System.out.println("LoginController.message");
          return "mvcDemo/adminLogin";
     }
     @PostMapping ("/login")
     public String postLogin(@RequestBody User user){
          System.out.println("LoginController.postLogin");
          
          return "mvcDemo/adminLogin";
     }
     
     
}
