package com.project.currencyexchangeservice.controller;

import com.project.currencyexchangeservice.entity.CurrencyExchange;
import com.project.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private CurrencyExchangeRepository repository;
    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to
    ){
        logger.info("retrieveExchangeValue called with {} to {}", from, to);
        CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
        if (Objects.isNull(currencyExchange)){
            throw new RuntimeException("Unable to Find data for: " + from + " to " + to);
        }
        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchange;
    }

}
