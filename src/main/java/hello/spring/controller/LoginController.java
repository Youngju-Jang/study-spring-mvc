package hello.spring.controller;

import hello.spring.entity.User;
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
          return "cart/adminLogin";
     }
     @PostMapping ("/login")
     public String postLogin(@ModelAttribute User user, HttpServletRequest request){
          String name = user.getName();
          String password = user.getPassword();
          boolean state = name.equals("Admin") && password.equals("123");
          if(state){
               request.getSession().setAttribute("userName", name);
               return "redirect:/product";
          }
          return "cart/adminLogin";
     }
     @GetMapping("/logout")
     public String logout(HttpServletRequest request){
          HttpSession session = request.getSession(false);
          if(session != null){
               session.invalidate();
          }
          return "cart/adminLogin";
     }
     
}
