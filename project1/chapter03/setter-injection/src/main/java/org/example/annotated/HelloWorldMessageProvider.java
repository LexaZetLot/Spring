package org.example.annotated;

import org.example.message.MessageProvider;
import org.springframework.stereotype.Component;

@Component("provider")
public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage(){
        return "Hello World!";
    }
}
