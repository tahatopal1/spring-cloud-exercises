package com.example.demo.controller;

import com.example.demo.model.HelloWorldBean;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@AllArgsConstructor
public class HelloWorldController {

    private MessageSource messageSource;

//    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    @GetMapping("hello-world/name/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean("Hello World,  " + name);
    }

    @GetMapping("/hello-world-internationalized")
    public String helloWorldInternationalized(@RequestHeader("Accept-Language") Locale locale){
        // Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
    }

}
