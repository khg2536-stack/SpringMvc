package com.oraclejava.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BmiController {

    @RequestMapping(value = "/bmi", method = RequestMethod.GET)
    public String bmiForm(){
        return "bmi";
    }

    @RequestMapping(value = "/bmi", method = RequestMethod.POST)
    public String calcBmi(@RequestParam("height") double height,
                          @RequestParam("weight") double weight,
                          Model model){
        double bmi = weight / ((height / 100) * (height / 100));
        model.addAttribute("bmi", bmi);
        return "bmi_result";
    }

}
