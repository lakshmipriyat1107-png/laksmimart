package com.priyamart.priyamart.control;
import org.springframework.stereotype.Controller; import org.springframework.web.bind.annotation.GetMapping;
@Controller public class HomeControl { @GetMapping("/") public String home(){return "forward:/index.html";} }
