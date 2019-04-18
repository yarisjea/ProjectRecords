package com.azurian.recordsws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Yarismel Correa
 **/

@SpringBootApplication
public class RecordsWsApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RecordsWsApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RecordsWsApplication.class);
    }
}
