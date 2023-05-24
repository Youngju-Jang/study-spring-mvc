package hello.spring.controller;

import hello.spring.dto.ProductDto;
import hello.spring.global.Page;
import hello.spring.global.PagingComponent;
import hello.spring.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
     
     private final ProductService productService;
     @GetMapping
     public String getList(@RequestParam(defaultValue = "1") int page,
                           @RequestParam(defaultValue = "") String search,
                           @RequestParam(defaultValue = "") String option, // enum으로 변경하기 PRODUCTNAME,PRODCUTCATEGORY, PRODCUTORIGIN
                           Model model){
          int totalRow = productService.countAll(); // 제품테이블 전체로우수
          Page pageBean = getPageBean(page, totalRow);
          
          HashMap<String, Object> map = createMap(search, option, pageBean); // db파라미터용 map 생성
          List<ProductDto> productList = productService.selectAll(map); // 페이징처리한 제품리스트
          
          model.addAttribute("pageBean",pageBean);
          model.addAttribute("productList", productList);
          
          return "cart/productList";
     }
     
     private static HashMap<String, Object> createMap(String search, String option, Page pageBean) {
          HashMap<String, Object> map = new HashMap<>();
          map.put("search", search);
          map.put("option", option);
          map.put("pageBean", pageBean);
          return map;
     }
     
     private static Page getPageBean(int page, int totalRow) {
          PagingComponent pagingComponent = new PagingComponent();
          Page pageBean = pagingComponent.pagingCreate(totalRow, page);
          return pageBean;
     }
}
