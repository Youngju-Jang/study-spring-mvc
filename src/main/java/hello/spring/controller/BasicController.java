package hello.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BasicController {

    @GetMapping("/message")
    public String message(Model model) {
        model.addAttribute("message", "메시지");
        return "basic/message";
    }

    @GetMapping("/lesson")
    public ModelAndView lesson() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("lesson", "springLesson");
        modelAndView.setViewName("basic/messageLesson");

        return modelAndView;
    }

    @GetMapping("/empValue")
    public String empValue() {
        return "basic/empForm";
    }

    @PostMapping("/empValue")
    public String empValueProcess(@RequestParam(value = "job", required = false, defaultValue = "doctor") String job,
                                  @RequestParam(value = "sal", required = false, defaultValue = "1000") int sal, Model model) {
        model.addAttribute("job", job);
        model.addAttribute("sal", sal);
        return "basic/empView";
    }

    @GetMapping("/lessonForm")
    public String lessonForm() {
        return "basic/lessonForm";
    }

    @PostMapping(value = "/lessonCheck")
    public String lessonCheckProcess(Model model, HttpServletRequest request) {
        String[] chValue = request.getParameterValues("lesson");
        model.addAttribute("chValue", chValue);
        return "basic/lessonCheck";
    }


}
