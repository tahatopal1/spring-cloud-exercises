package com.project.limitsservice.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("limit-service")
@Component
@Getter
@Setter
public class LimitServiceConfiguration {

    private int minimum;
    private int maximum;

}
