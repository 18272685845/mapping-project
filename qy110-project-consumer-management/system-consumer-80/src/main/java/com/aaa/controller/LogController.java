package com.aaa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LogController {

    @RequestMapping("/")
    public String doMain(){
        return "login";
    }
}
