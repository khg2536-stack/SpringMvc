package com.oraclejava.springmvc;

//import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
public class HelloController {

    @RequestMapping
    public String index(Model model){
        model.addAttribute("msg", "안녕하세요");
        model.addAttribute("now", LocalDateTime.now());
        return "index";
    }
}
