package com.ryanrivera.app.frontdesk.client.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Locale;

public class OffsetDateTimeFormatter implements Formatter<OffsetDateTime> {

    @Override
    public OffsetDateTime parse(String text, Locale locale) throws ParseException {
        final long millis = Long.parseLong(text);
        return OffsetDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneOffset.UTC);
    }

    @Override
    public String print(OffsetDateTime object, Locale locale) {
        return String.valueOf(object.toInstant().toEpochMilli());
    }
}
