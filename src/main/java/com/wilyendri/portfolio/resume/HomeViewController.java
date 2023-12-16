package com.wilyendri.portfolio.resume;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeViewController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/send-email")
    public String email() {
        return "email";
    }

}
