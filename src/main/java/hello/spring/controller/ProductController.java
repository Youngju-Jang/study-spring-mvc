package hello.spring.controller;

import hello.spring.dto.ProductRequestDto;
import hello.spring.dto.ProductResponseDto;
import hello.spring.entity.User;
import hello.spring.global.Page;
import hello.spring.global.PagingComponent;
import hello.spring.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Controller
@RequestMapping ("**/product")
@RequiredArgsConstructor
public class ProductController {
     
     private final ProductService productService;
     
     @PostMapping (value = "/add") // 제품등록
     public String addProduct(@ModelAttribute ProductRequestDto productRequestDto,
                              HttpServletRequest request) throws IOException {
          User user = (User) request.getSession().getAttribute("user");
          productService.productInsert(productRequestDto, user);
          
          return "redirect:/product/add";
     }
     
     @GetMapping ("/add")
     public String getProductView(HttpServletRequest request) {
          User user = (User) request.getSession().getAttribute("user");
          if (user == null) {
               System.out.println("ProductController.getProductView");
               return "redirect:/login";
          }
          return "/cart/productAdd";
     }
     
     @GetMapping ("/pageBean")
     public String getPageBean(@RequestParam (defaultValue = "1") int page,
                               @RequestParam (defaultValue = "") String search,
                               @RequestParam (defaultValue = "") String option, // enum으로 변경하기 PRODUCTNAME,PRODCUTCATEGORY, PRODCUTORIGIN
                               @RequestParam (defaultValue = "false") boolean forAdmin,
                               Model model) {
          int totalRow = productService.countAll(); // 제품테이블 전체로우수
          Page pageBean = getPageBean(page, totalRow);
          
          System.out.println("forAdmin " + forAdmin);
          
          HashMap<String, Object> map = createMap(search, option, pageBean); // db파라미터용 map 생성
          List<ProductResponseDto> productList = productService.selectAll(map); // 페이징처리한 제품리스트
          
          model.addAttribute("pageBean", pageBean);
          model.addAttribute("productList", productList);
          model.addAttribute("search", search);
          model.addAttribute("option", option);
          
          return "cart/paginationView";
     }
     
     @GetMapping
     public String getList(@RequestParam (defaultValue = "1") int page,
                           @RequestParam (defaultValue = "") String search,
                           @RequestParam (defaultValue = "") String option, // enum으로 변경하기 PRODUCTNAME,PRODCUTCATEGORY, PRODCUTORIGIN
                           @RequestParam (defaultValue = "false") boolean forAdmin,
                           Model model) {
          int totalRow = productService.countAll(); // 제품테이블 전체로우수
          Page pageBean = getPageBean(page, totalRow);
          
          HashMap<String, Object> map = createMap(search, option, pageBean); // db파라미터용 map 생성
          List<ProductResponseDto> productList = productService.selectAll(map); // 페이징처리한 제품리스트
          
          model.addAttribute("pageBean", pageBean);
          model.addAttribute("productList", productList);
          model.addAttribute("search", search);
          model.addAttribute("option", option);
          
          if (forAdmin) {
//               return "cart/productAddView";
               return "cart/paginationView";
          }
          
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
