package hello.spring.controller;

import hello.spring.model.Page;
import hello.spring.model.PagingComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {
     @GetMapping
     public String getList(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "") String search,
                           Model model){
          
          int totalRow = 10; // 수정필요
          Page pageBean = getPageBean(page, totalRow);
          model.addAttribute("pageBean",pageBean);
          
          return "cart/productList";
     }
     
     private static Page getPageBean(int page, int totalRow) {
          PagingComponent pagingComponent = new PagingComponent();
          Page pageBean = pagingComponent.pagingCreate(totalRow, page);
          return pageBean;
     }
}
