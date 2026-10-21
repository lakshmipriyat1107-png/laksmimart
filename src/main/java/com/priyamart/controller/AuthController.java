package com.priyamart.controller;
import com.priyamart.model.User; import com.priyamart.repository.UserRepository; import jakarta.servlet.http.HttpSession; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.*;
@Controller public class AuthController{
 private final UserRepository users; public AuthController(UserRepository u){users=u;}
 @GetMapping("/login") public String login(){return "login";}
 @PostMapping("/login") public String doLogin(@RequestParam String email,@RequestParam String password,HttpSession s,Model m){User u=users.login(email,password);if(u==null){m.addAttribute("error","Invalid email or password");return "login";}s.setAttribute("user",u);return "ADMIN".equals(u.getRole())?"redirect:/admin":"redirect:/products";}
 @GetMapping("/register") public String register(){return "register";}
 @PostMapping("/register") public String doRegister(@RequestParam String name,@RequestParam String email,@RequestParam String password,Model m){if(users.exists(email)){m.addAttribute("error","Email already registered");return "register";}users.register(name,email,password);m.addAttribute("message","Account created. Please login.");return "login";}
 @GetMapping("/logout") public String logout(HttpSession s){s.invalidate();return "redirect:/login";}
}