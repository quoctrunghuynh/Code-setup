package com.databinding.demodatabinding.controller;

import com.databinding.demodatabinding.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @RequestMapping(value="showForm", method = RequestMethod.GET)
    public String showForm(ModelMap model){
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @RequestMapping(value = "addEmployee", method = RequestMethod.POST)
    public String submit(@ModelAttribute("employee") Employee employee,
                         ModelMap modelMap){
        modelMap.addAttribute("name", employee.getName());
        modelMap.addAttribute("contactNumber", employee.getContactNumber());
        modelMap.addAttribute("id", employee.getId());
        return "employee/info";
    }
}
