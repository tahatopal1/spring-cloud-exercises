package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
//@JsonIgnoreProperties({"field1", "field2"})
@JsonFilter("SomeBeanFilter")
public class SomeBean {

    private String field1;
    //@JsonIgnore
    private String field2;
    private String field3;


}
