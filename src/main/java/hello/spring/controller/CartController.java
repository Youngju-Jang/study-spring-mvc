package hello.spring.controller;

import hello.spring.SessionConst;
import hello.spring.entity.Cart;
import hello.spring.entity.User;
import hello.spring.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Comparator;
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
                           @SessionAttribute (name = SessionConst.CART_SET, required = false) List<Cart> oriCartSet,
                           @RequestParam (value = "newCartIntSet") Set<Integer> newCartIntSet,
                           HttpServletRequest request) {
          // 기존세션에 없는 cart intSet 뽑기
          Set<Integer> filteredNewIntSet = getFilteredNewIntSet(oriCartSet, newCartIntSet);
          List<Cart> newCartSet = cartService.selectAllByNoSet(filteredNewIntSet); // 여기 Ori new 합쳐야함. 중복시 기존껄로
          
          if (oriCartSet != null) {
               newCartSet = concatOriNew(oriCartSet, newCartSet);
          }
          request.getSession().setAttribute(SessionConst.CART_SET, newCartSet);
          return "redirect:/cart";
     }
     
     // 기존 CartSet 와 새 CartSet 합치기
     private static List<Cart> concatOriNew(List<Cart> oriCartSet, List<Cart> newCartSet) {
          return Stream.concat(oriCartSet.stream(), newCartSet.stream())
               .sorted(Comparator.comparingInt(Cart::getNo))
               .collect(Collectors.toList());
     }
     
     // 기존세션에 없는 cart intSet 뽑기
     private static Set<Integer> getFilteredNewIntSet(List<Cart> oriCartSet, Set<Integer> newCartIntSet) {
          return (oriCartSet == null) ? newCartIntSet :
               newCartIntSet.stream()
                    .filter(i -> oriCartSet.stream().noneMatch(cart -> cart.getNo() == i))
                    .collect(Collectors.toSet());
     }
     
     @GetMapping
     public String getCart(@SessionAttribute (name = SessionConst.LOGIN_USER) User user,
                           @SessionAttribute (name = SessionConst.CART_SET, required = false) List<Cart> oriCartSet,
                           @RequestParam (defaultValue = "1") int page,
                           Model model) {
          // paging 적용하기 TODO
          List<Cart> cartSet = null;
          if (oriCartSet != null) {
               cartSet = cartService.selectAllByNoSet(Cart.getNoList(oriCartSet));
          }
          model.addAttribute("cartSet", cartSet);
          return "cart/cartList";
     }
}
