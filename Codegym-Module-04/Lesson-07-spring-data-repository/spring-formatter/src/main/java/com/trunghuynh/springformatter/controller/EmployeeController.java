package com.trunghuynh.springformatter.controller;

import com.trunghuynh.springformatter.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {
    @RequestMapping("/add-employee")
    public String inputEmployee(Model model) {
        model.addAttribute(new Employee());
        return "create";
    }

    @RequestMapping("/save-employee")
    public String saveEmployee(@ModelAttribute Employee employee, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            return "create";
        }

        // save employee here

        model.addAttribute("employee", new Employee());
        return "create";
    }
}
