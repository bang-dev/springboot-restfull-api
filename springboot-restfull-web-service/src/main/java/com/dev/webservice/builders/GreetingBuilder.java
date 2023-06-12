package com.dev.webservice.builders;

import com.dev.webservice.models.Greeting;

public class GreetingBuilder {
    private Greeting greeting;

    public GreetingBuilder() {
        if(greeting == null) {
            this.greeting = new Greeting();
        }
    }

    public GreetingBuilder id(long id) {
        greeting.setId(id);
        return this;
    }
    public GreetingBuilder content(String content) {
        greeting.setContent(content);
        return this;
    }

    public Greeting build() {
        return greeting;
    }
}
