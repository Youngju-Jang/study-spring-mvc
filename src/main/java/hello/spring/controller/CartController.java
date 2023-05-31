package hello.spring.controller;

import hello.spring.SessionConst;
import hello.spring.dto.ProductResponseDto;
import hello.spring.entity.Product;
import hello.spring.entity.User;
import hello.spring.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Controller
@RequestMapping ("/cart")
@RequiredArgsConstructor
public class CartController {
     private final CartService cartService;
     
     @PostMapping ("/add")
     public String addCart(@SessionAttribute (name = SessionConst.LOGIN_USER) User user,
                           @SessionAttribute (name = SessionConst.CART_SET, required = false) Set<Integer> oriCartSet,
                           @RequestParam (value = "newCartSet") Set<Integer> newCartSet,
                           HttpServletRequest request) {
          if (oriCartSet != null) {
               newCartSet = Stream.concat(oriCartSet.stream(), newCartSet.stream())
                    .collect(Collectors.toSet());
          }
          request.getSession().setAttribute(SessionConst.CART_SET, newCartSet);
          
          return "redirect:/cart";
     }
     
     @GetMapping
     public String getCart(@SessionAttribute (name = SessionConst.LOGIN_USER) User user,
                           @SessionAttribute (name = SessionConst.CART_SET, required = false) Set<Integer> cartSet,
                           @RequestParam (defaultValue = "1") int page,
                           Model model) {
          // paging 적용하기
          List<ProductResponseDto> productList = cartService.selectAllByNoSet(cartSet);
          model.addAttribute("productList", productList);
          return "cart/cartList";
     }
}
