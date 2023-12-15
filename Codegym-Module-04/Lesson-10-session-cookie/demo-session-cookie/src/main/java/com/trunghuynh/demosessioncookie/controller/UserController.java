package com.trunghuynh.demosessioncookie.controller;

import com.trunghuynh.demosessioncookie.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class UserController {

    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "/login";
    }

    @PostMapping("/login")
    public String Index(Model model,
                        @ModelAttribute("user") User user,
                        HttpServletResponse response) {
        String username = user.getEmail();
        String password = user.getPassword();

        String token;
        if (username.equals("thaidui") && password.equals("Abcd1234")) {
            token = "thaikodui";
            Cookie cookie = new Cookie("token", token);
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
            model.addAttribute("message", "success");
            return "/login";
        } else {
            model.addAttribute("message", "login fail");
        }
        return "/login";

    }
}
