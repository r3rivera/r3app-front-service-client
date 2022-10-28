package com.ryanrivera.app.frontdesk.client.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
@RequiredArgsConstructor
public class FeignClientCustomHeaderInterceptor implements RequestInterceptor {
    private final HttpServletRequest request;

    @Override
    public void apply(RequestTemplate template) {
        log.info("#### Adding OFClient Header");
        log.info("#### Custom Header ::" + request.getHeader("X-Some-Ryan-Header"));
        template.header("x-source-application-code", "OFClient");
    }
}
