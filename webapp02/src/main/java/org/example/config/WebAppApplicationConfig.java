package org.example.config;

import org.example.formatter.CreditCardFormatter;
import org.example.formatter.CurrencyFormatter;
import org.example.formatter.PhoneNumberFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Properties;
import java.util.logging.Logger;

@EnableWebMvc
@Configuration
@ComponentScans({@ComponentScan(basePackages = "org.example"),})
@PropertySource("classpath:email.properties")
public class WebAppApplicationConfig implements WebMvcConfigurer {
    @Autowired
    private Environment env;
    Logger logger = Logger.getLogger(WebAppApplicationConfig.class.getName());

    @Bean
    InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new PhoneNumberFormatter());
        registry.addFormatter(new CurrencyFormatter());
        registry.addFormatter(new CreditCardFormatter());
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean validator(){
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setValidationMessageSource(messageSource());
        return validator;
    }

    @Override
    public Validator getValidator() {
        return validator();
    }

    @Bean
    public JavaMailSenderImpl getJavaMailSender(){
        logger.info("fetching the host value " + env.getProperty("mail.host"));
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(env.getProperty("mail.host"));
        mailSender.setUsername(env.getProperty("mail.username"));
        mailSender.setPassword(env.getProperty("mail.password"));
        mailSender.setPort(getIntProperty("mail.port"));
        mailSender.setJavaMailProperties(getMailProperties());
        return mailSender;
    }

    private Properties getMailProperties(){
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        return props;
    }

    int getIntProperty(String key) {
        String value = env.getProperty(key);
        assert value != null;
        return Integer.parseInt(value);
    }
}
