package hello.spring.controller;

import hello.spring.dto.BitDemoDto;
import hello.spring.service.BitDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BitDemoController {
     @Autowired
     private BitDemoService bitDemoService;
     
     @PostMapping(value = "")
     public String insertDemoService(@ModelAttribute BitDemoDto bitDemoDto){
          System.out.println("name : " + bitDemoDto.getName());
          bitDemoService.bitDemoInsert(bitDemoDto);
          return "mvcDemo/list";
     }
     
}
