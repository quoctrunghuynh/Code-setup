package com.trunghuynh.simplecalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping
    public String getHome() {
        return "index";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam("number1") Integer number1,
                            @RequestParam("number2") Integer number2,
                            @RequestParam("method") String method,
                            ModelMap modelMap) {
        int result = 0;
        switch (method) {
            case "1":
                result = number1 + number2;
                break;
            case "2":
                result = number1 - number2;
                break;
            case "3":
                result = number1 * number2;
                break;
            case "4":
                result = number1 / number2;
                break;
        }
        modelMap.addAttribute("result", result);
        return "index";
    }
}
