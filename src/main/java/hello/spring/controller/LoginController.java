package hello.spring.controller;

import hello.spring.SessionConst;
import hello.spring.entity.User;
import hello.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class LoginController {
     private final UserService userService;
     
     @GetMapping ("/login")
     public String message(@CookieValue(value = "name",required = false)Cookie cookie,
                           Model model) {//쿠키생성 여부 확인
          if(cookie!=null){
               model.addAttribute("name", cookie.getValue());
          }
          return "cart/adminLogin";
     }
     
     @PostMapping ("/login")
     public String postLogin(@ModelAttribute User user,
                             @RequestParam (value = "checker") String checker,
                             @RequestParam (defaultValue = "/product") String redirectURL,
                             HttpServletRequest request
                              , HttpServletResponse response) {
          String name = user.getName();
          String password = user.getPassword();
          //쿠키....
          Cookie cookie = new Cookie("name", name);
          cookie.setMaxAge((checker != null) ? 500 : 0);
          response.addCookie(cookie);
          
          if (!userService.isExist(name)) {
               return "/cart/adminLogin";
          }
          User existUser = userService.selectByName(name);
          if (existUser.getPassword().equals(password)) {
               request.getSession().setAttribute(SessionConst.LOGIN_USER, existUser);
               return "redirect:"+redirectURL;
          }
          return "/cart/adminLogin";
     }
     
     @GetMapping ("/logout")
     public String logout(HttpServletRequest request) {
          HttpSession session = request.getSession(false);
          if (session != null) {
               session.invalidate();
          }
          return "/cart/adminLogin";
     }
     
}
