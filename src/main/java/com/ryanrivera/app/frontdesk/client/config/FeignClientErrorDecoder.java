package com.ryanrivera.app.frontdesk.client.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ryanrivera.app.frontdesk.client.exception.FrontDeskAppServiceException;
import com.ryanrivera.app.frontdesk.client.exception.FrontDeskErrorResponse;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Component
public class FeignClientErrorDecoder implements ErrorDecoder {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private ErrorDecoder.Default defaultDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {

        try(InputStream inputStream = response.body().asInputStream()){
            FrontDeskErrorResponse errorResponse = objectMapper.readValue(inputStream, FrontDeskErrorResponse.class);
            return new FrontDeskAppServiceException(errorResponse.getMessage());
        }catch(IOException io){
            log.error("Error handling the exception message");
            throw new RuntimeException("Unable to process error message!");
        }
    }
}
