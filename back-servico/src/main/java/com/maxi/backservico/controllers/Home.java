package com.maxi.backservico.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/")
public class Home {

    @GetMapping(value = "/")
    public String home(){
        return "Hola mundo";
    }
    
}
