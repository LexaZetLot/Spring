package org.example.mixed;

import org.example.message.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldSpringMixed {
    public static void main(String[] argv){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
    }
}
