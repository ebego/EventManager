package com.eventmanager.api;

import com.eventmanager.api.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
public class EventManagerApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(EventManagerApiApplication.class, args);
    }

}
