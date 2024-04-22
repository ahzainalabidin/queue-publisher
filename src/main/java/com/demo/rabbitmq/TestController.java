package com.demo.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TestController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/test/{name}")
    public String testAPI(@PathVariable("name") String name) {
        Person person = new Person(1L, name);
        rabbitTemplate.convertAndSend("Mobile", person);
        return "Success";
    }

}
