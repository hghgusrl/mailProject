package com.example.mailproject.controller;

import com.example.mailproject.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SendController {

    @Autowired
    SendService sendService;

    @GetMapping("/test")
    public String test(){
        boolean r = sendService.sendMail();
        System.out.println("test - "+r);
        return "";
    }

}
