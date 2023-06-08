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
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Controller
@RequestMapping ("/cart")
@RequiredArgsConstructor
public class CartController {
     private final CartService cartService;
     
     @GetMapping("/add/{no}")
     @ResponseBody
     public String addCart(@SessionAttribute (name = SessionConst.LOGIN_USER) User user,
                           @SessionAttribute (name = SessionConst.CART_SET, required = false) List<Cart> sessionCartList,
                           @PathVariable(required = true) Integer no,
                           HttpServletRequest request){
          if(!(sessionCartList ==null)){ // 기존 장바구니세션이 있을경우
               Optional<Cart> cart = sessionCartList.stream().filter(c -> c.getNo()==no).findFirst();
               if(cart.isPresent()){ // 세션장바구니에 추가제품이 이미 들어있는경우
                    return "DUPLICATED";
               }
          }
          Cart newCart = cartService.selectByNo(no);
          if(newCart==null){
               return "NOTEXIST";
          }
          if(sessionCartList == null){
               sessionCartList = new ArrayList<>();
          }
          sessionCartList.add(newCart);
          request.getSession().setAttribute(SessionConst.CART_SET, sessionCartList);
          return "OK";
     }
     
     @PostMapping ("/add")
     public String addCartList(@SessionAttribute (name = SessionConst.LOGIN_USER) User user,
                               @SessionAttribute (name = SessionConst.CART_SET, required = false) List<Cart> oriCartSet,
                               @RequestParam (value = "newCartIntSet") Set<Integer> newCartIntSet,
                               HttpServletRequest request) {
          // 기존세션에 없는 cart intSet 뽑기
          Set<Integer> filteredNewIntSet = getFilteredNewIntSet(oriCartSet, newCartIntSet);
          List<Cart> newCartSet = null;
          
          if (!filteredNewIntSet.isEmpty()) { // 겹치는거 빼고나니 새로 추가된 장바구니가 없는경우
               newCartSet = cartService.selectAllByNoSet(filteredNewIntSet); // 여기 Ori new 합쳐야함. 중복시 기존껄로
          }
          if (oriCartSet != null) {
               newCartSet = concatOriNew(oriCartSet, newCartSet);
          }
          request.getSession().setAttribute(SessionConst.CART_SET, newCartSet);
          return "redirect:/cart";
     }
     
     // 기존 CartSet 와 새 CartSet 합치기
     private static List<Cart> concatOriNew(List<Cart> oriCartSet, List<Cart> newCartSet) {
          if(newCartSet == null){
               return oriCartSet;
          }
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
