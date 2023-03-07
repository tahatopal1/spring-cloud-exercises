package com.project.limitsservice.controller;

import com.project.limitsservice.configuration.LimitServiceConfiguration;
import com.project.limitsservice.entity.Limit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {

    @Autowired
    private LimitServiceConfiguration limitServiceConfiguration;

    @GetMapping("/limit")
    public Limit retrieveLimits(){
        //return new Limit(1, 1000);
        return new Limit(limitServiceConfiguration.getMinimum(), limitServiceConfiguration.getMaximum());
    }

}
