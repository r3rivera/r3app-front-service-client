package com.ryanrivera.app.frontdesk.client.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.ryanrivera.app.frontdesk.client.exception.ErrorResponse;
import com.ryanrivera.app.frontdesk.client.exception.FrontDeskAppServiceException;
import com.ryanrivera.app.frontdesk.client.exception.FrontDeskErrorResponse;
import com.ryanrivera.app.frontdesk.client.feign.FeignAppServiceClient;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
public class FeignClientErrorDecoder implements ErrorDecoder {
    private ErrorDecoder.Default defaultDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        try(InputStream inputStream = response.body().asInputStream()){
            final ObjectMapper objectMapper = objectMapper();
            final ErrorResponse errorResponse = objectMapper.readValue(inputStream, ErrorResponse.class);

            String apiName = methodKey.substring(0, methodKey.indexOf("#"));
            if(FeignAppServiceClient.class.getName().contains(apiName)){
                return new FrontDeskAppServiceException(errorResponse);
            }

        }catch(IOException io){
            log.error("Error handling the exception message");
        }
        return defaultDecoder.decode(methodKey, response);
    }

    private ObjectMapper objectMapper(){
        final JavaTimeModule module = new JavaTimeModule();
        final LocalDateTimeDeserializer localDateTimeDeserializer =
                new LocalDateTimeDeserializer(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        module.addDeserializer(LocalDateTime.class, localDateTimeDeserializer);
        final ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json()
                .modules(module)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .build();
        return objectMapper;
    }


}
