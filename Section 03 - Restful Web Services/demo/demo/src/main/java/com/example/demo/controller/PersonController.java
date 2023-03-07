package com.example.demo.controller;

import com.example.demo.model.Name;
import com.example.demo.model.PersonV1;
import com.example.demo.model.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    // URL versioning (Twitter)
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    // Request versioning (Amazon)
    @GetMapping(value = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfRequestParameter(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfRequestParameter(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    // Header versioning (Microsoft)
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfRequestHeader(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfRequestHeader(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    // Media type versioning (a.k.a "content negotiation" or "accep header - GitHub)
    @GetMapping(value = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfAccessHeader(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfAccessHeader(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}
