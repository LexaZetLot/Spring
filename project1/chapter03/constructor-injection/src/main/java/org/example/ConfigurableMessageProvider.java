package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("provider")
public class ConfigurableMessageProvider implements MessageProvider{
    private String message;

    @Autowired
    public ConfigurableMessageProvider(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
