package org.example;

import org.example.mixed.AppConfigFive;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigExampleTwo {
    public static void main(String... args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigFive.class);

        MessageRenderer renderer = ctx.getBean("messageRenderer", MessageRenderer.class);

        renderer.render();
    }
}