package com.example.demo.controller;

import com.example.demo.config.CurrencyServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {

    @Autowired
    private CurrencyServiceConfiguration conf;

    @GetMapping("/currency-configuration")
    public CurrencyServiceConfiguration retrieveAllConfigurations(){
        return conf;
    }

}
