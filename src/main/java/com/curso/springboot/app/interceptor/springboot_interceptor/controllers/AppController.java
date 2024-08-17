package com.curso.springboot.app.interceptor.springboot_interceptor.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")

public class AppController {

    @GetMapping("/foo")
    public Map<String, String> foo(){

        return Collections.singletonMap("messafe", "foo");


    }

    @GetMapping("/bar")
    public Map<String, String> bar(){

        return Collections.singletonMap("messafe", "bar");


    }
    

    @GetMapping("/baz")
    public Map<String, String> baz(){

        return Collections.singletonMap("messafe", "baz");


    }

}
