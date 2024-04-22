package com.demo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class Publisher {

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

//        String message = "First message from RabbitMQ";

        String[] messages = {"First", "Second", "Third", "Fourth"};

        for (String message : messages) {
            channel.basicPublish("", "Queue-1", null, message.getBytes());
        }

        channel.close();
        connection.close();

    }

}
