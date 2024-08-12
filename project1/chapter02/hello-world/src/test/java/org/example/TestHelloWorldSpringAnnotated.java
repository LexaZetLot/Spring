package org.example;

import org.example.annotated.HelloWorldConfiguration;
import org.example.decoupled.MessageRenderer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertNotNull;

public class TestHelloWorldSpringAnnotated {

    @Test
    public void testHello() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        assertNotNull(mr);
    }
}