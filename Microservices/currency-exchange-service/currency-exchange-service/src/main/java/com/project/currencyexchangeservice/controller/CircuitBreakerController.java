package com.project.currencyexchangeservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample")
//    @Retry(name = "default")
    @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
    public String sampleApi(){
        logger.info("Sample API call received!");
        ResponseEntity<String> entity
                = new RestTemplate().getForEntity("http:localhost:9000/some-dummy-url", null, String.class);
        return entity.getBody();
    }

    // A blanked method covers all exceptions
    // Could have generated more methods to target more specific exceptions
    public String hardcodedResponse(Exception ex){
        return "fallback-response";
    }

    @GetMapping("/sample2")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
    public String sample2(){
        logger.info("Sample2 API call received!");
        ResponseEntity<String> entity
                = new RestTemplate().getForEntity("http:localhost:9000/some-dummy-url", null, String.class);
        return entity.getBody();
    }

    @GetMapping("/sample3")
    @RateLimiter(name = "default3") // in 10s => only allow 10000 request
    public String sample3(){
        logger.info("Sample2 API call received!");
        ResponseEntity<String> entity
                = new RestTemplate().getForEntity("http:localhost:9000/some-dummy-url", null, String.class);
        return entity.getBody();
    }


}
