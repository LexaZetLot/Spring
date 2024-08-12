package org.example;

import org.example.message.MessageProvider;

public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage(){
        return "Hello World!";
    }
}
