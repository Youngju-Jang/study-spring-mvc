package hello.spring.controller;

import hello.spring.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
     @GetMapping("/login")
     public String message(){
          System.out.println("LoginController.message");
          return "mvcDemo/adminLogin";
     }
     @PostMapping ("/login")
     public String postLogin(@ModelAttribute User user, HttpServletRequest request){
          System.out.println("LoginController.postLogin");
          String name = user.getName();
          String password = user.getPassword();
          boolean state = name.equals("Admin") && password.equals("123");
          if(state){
               request.getSession().setAttribute("userName", name);
               return "mvcDemo/list";
          }
          return "mvcDemo/adminLogin";
     }
     @GetMapping("/logout")
     public String logout(HttpServletRequest request){
          HttpSession session = request.getSession(false);
          if(session != null){
               session.invalidate();
          }
          return "mvcDemo/adminLogin";
     }
     
}
