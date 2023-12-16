package com.wilyendri.portfolio.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {
    @Autowired
    EmailService emailService;

    @PostMapping("/send-email")
    public String sendEmail(@RequestParam String subject,
                            @RequestParam String text)
    {
        emailService.sendEmail(subject, text);

        return "redirect:/";
    }
}
