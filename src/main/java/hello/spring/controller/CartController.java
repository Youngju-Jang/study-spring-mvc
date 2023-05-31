package hello.spring.controller;

import hello.spring.SessionConst;
import hello.spring.entity.User;
import hello.spring.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
     private final CartService cartService;
     
     @PostMapping("/add")
     public String addCart(@SessionAttribute(name= SessionConst.LOGIN_USER) User user){
          
          return "redirect:/cart";
     }
     
     @GetMapping()
     public String getCart(@SessionAttribute(name= SessionConst.LOGIN_USER) User user,
                           @RequestParam (defaultValue = "1") int page){
          return "cart/cartList";
     }
}
