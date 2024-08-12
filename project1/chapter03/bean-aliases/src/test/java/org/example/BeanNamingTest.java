package org.example;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Map;

public class BeanNamingTest {
    @Test
    public void testNaming(){
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-01.xml");
        ctx.refresh();

        Map<String, String> beans = ctx.getBeansOfType(String.class);
        beans.entrySet().stream().forEach(b -> System.out.println(b.getKey()));

        ctx.close();
    }
}
