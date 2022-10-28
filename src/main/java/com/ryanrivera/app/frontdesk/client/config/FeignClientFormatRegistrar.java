package com.ryanrivera.app.frontdesk.client.config;

import com.ryanrivera.app.frontdesk.client.formatter.OffsetDateTimeFormatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignFormatterRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;

@Slf4j
@Configuration
public class FeignClientFormatRegistrar implements FeignFormatterRegistrar {

    @Override
    public void registerFormatters(FormatterRegistry registry) {
        registry.addFormatter(new OffsetDateTimeFormatter());
    }
}
