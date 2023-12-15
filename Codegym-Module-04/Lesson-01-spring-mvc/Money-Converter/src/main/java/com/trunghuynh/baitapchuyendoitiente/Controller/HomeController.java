package com.trunghuynh.baitapchuyendoitiente.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping(value = "/convert")
    public String convert(@ModelAttribute("exchangeRate") double exchangeRate,
                          @ModelAttribute("usdAmount") double usdAmount,
                          Model model,BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            System.err.println("binding result has a problem");
        }
        double vndAmount = usdAmount * exchangeRate;
        BigDecimal bigDecimal = BigDecimal.valueOf(vndAmount);
        String numberInString = bigDecimal.toPlainString();
        model.addAttribute("vndAmount", numberInString);
        return "index";
    }
}