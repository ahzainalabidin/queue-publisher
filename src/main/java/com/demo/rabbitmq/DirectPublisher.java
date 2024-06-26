package com.demo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class DirectPublisher {

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

//        String message = "This is mobile";
//        channel.basicPublish("Direct-Exchange", "mobile", null, message.getBytes());

//        String message = "This is ac";
//        channel.basicPublish("Direct-Exchange", "ac", null, message.getBytes());

        String message = "This is tv";
        channel.basicPublish("Direct-Exchange", "tv", null, message.getBytes());

        channel.close();
        connection.close();

    }

}
