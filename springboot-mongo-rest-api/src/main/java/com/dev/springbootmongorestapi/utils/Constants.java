package com.dev.springbootmongorestapi.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {
    public static final String EMAIL_PATTERN =
            "^\\p{Alnum}[\\p{Alnum}_.-]+@((\\p{Alnum}[\\p{Alnum}-]*)\\.)+\\p{Alnum}+$";
    public static final ObjectMapper MAPPER = new ObjectMapper();
    public static final int DEFAULT_PAGE = 1;
    public static final int DEFAULT_PAGE_SIZE = 10;
    public static final String DEFAULT_ORDER = "desc";

    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm";
    public static final String DATE_PATTERN = "yyyy-MM-dd";

    public static final String JOB_PARAM_RESOURCE_CONTENT = "resourceContent";

    public static final String NEW_HTML_LINE = "<br />";

    static {
        MAPPER.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, false);
        MAPPER.registerModule(new JavaTimeModule());
        MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

}
