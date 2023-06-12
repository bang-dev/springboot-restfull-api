package com.dev.webservice.models;

import com.dev.webservice.builders.GreetingBuilder;

public class Greeting {

    private static long id;
    private static String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        Greeting.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        Greeting.content = content;
    }
}
