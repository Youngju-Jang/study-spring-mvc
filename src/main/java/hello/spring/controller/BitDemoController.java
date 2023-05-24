package hello.spring.controller;

import hello.spring.dto.BitDemoDto;
import hello.spring.service.BitDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BitDemoController {
     @Autowired
     private BitDemoService bitDemoService;
     
     @GetMapping("/addDemo")
     public String addDemoService(){
          return "mvcDemo/addDemo";
     }
     
     @PostMapping(value = "/addDemo")
     public String insertDemoService(@ModelAttribute BitDemoDto bitDemoDto){
          bitDemoService.bitDemoInsert(bitDemoDto);
          return "redirect:/demoBitList";
     }
     
     @GetMapping("demoBitList")
     public String listDemoService(Model model){
          model.addAttribute("demoList",bitDemoService.selectAll());
          return "mvcDemo/DemoList";
     }
     
     
     
}
