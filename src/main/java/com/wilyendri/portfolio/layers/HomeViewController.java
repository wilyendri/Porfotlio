package com.wilyendri.portfolio.layers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeViewController {
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/resume")
    public String resume() {
        return "resume";
    }
}
