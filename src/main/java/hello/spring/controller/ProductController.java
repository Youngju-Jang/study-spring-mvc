package hello.spring.controller;

import hello.spring.dto.ProductRequestDto;
import hello.spring.dto.ProductResponseDto;
import hello.spring.global.Page;
import hello.spring.global.PagingComponent;
import hello.spring.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("**/product")
@RequiredArgsConstructor
public class ProductController {
     
     private final ProductService productService;
     
     @PostMapping(value = "/add") // 제품등록
     public String addProduct(@ModelAttribute ProductRequestDto productRequestDto){
          System.out.println("productRequestDto = " + productRequestDto);
          return "/product/add";
     }
     
     @GetMapping("/add")
     public String getProductView(HttpServletRequest request){
          Integer loggedUserId = (Integer)request.getSession().getAttribute("userId");
          if(loggedUserId==null){
//               return "redirect:/login";
          }
          return "/cart/productAdd";
     }
     @GetMapping
     public String getList(@RequestParam(defaultValue = "1") int page,
                           @RequestParam(defaultValue = "") String search,
                           @RequestParam(defaultValue = "") String option, // enum으로 변경하기 PRODUCTNAME,PRODCUTCATEGORY, PRODCUTORIGIN
                           Model model){
          int totalRow = productService.countAll(); // 제품테이블 전체로우수
          Page pageBean = getPageBean(page, totalRow);
          
          HashMap<String, Object> map = createMap(search, option, pageBean); // db파라미터용 map 생성
          List<ProductResponseDto> productList = productService.selectAll(map); // 페이징처리한 제품리스트
          
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
