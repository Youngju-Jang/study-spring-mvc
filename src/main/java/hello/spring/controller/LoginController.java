package hello.spring.controller;

import hello.spring.entity.User;
import hello.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class LoginController {
     private final UserService userService;
     @GetMapping("/login")
     public String message(){
          return "cart/adminLogin";
     }
     
     @PostMapping ("/login")
     public String postLogin(@ModelAttribute User user, HttpServletRequest request){
          String name = user.getName();
          String password = user.getPassword();
          
          if(!userService.isExist(name)){
               return "/cart/adminLogin";
          }
          User existUser = userService.selectByName(name);
          if(existUser.getPassword().equals(password)){
               request.getSession().setAttribute("userName", name);
               request.getSession().setAttribute("userId", existUser.getUserId());
               return "redirect:/product";
          }
          return "/cart/adminLogin";
     }
     @GetMapping("/logout")
     public String logout(HttpServletRequest request){
          HttpSession session = request.getSession(false);
          if(session != null){
               session.invalidate();
          }
          return "/cart/adminLogin";
     }
     
}
