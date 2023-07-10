package com.example.mailproject.controller;

import com.example.mailproject.service.ReadService;
import org.springframework.stereotype.Controller;

@Controller
public class ReadController {

    final ReadService readService;

    public ReadController(ReadService readService) {
        this.readService = readService;
    }

    public String test(){

        readService.read();

        return "";
    }
}
