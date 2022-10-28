package com.ryanrivera.app.frontdesk.client.config;

import feign.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Slf4j
@Configuration
@Profile("!prod")
public class FeignClientLogConfig {

    @Bean
    public Logger.Level loggerLevel(){
        log.info("Enable Feign Full Logging in Profile!");
        return Logger.Level.FULL;
    }
}
