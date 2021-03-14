package com.rabbitmq._6_headers;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.ExchangeTypes;

import java.util.HashMap;
import java.util.Map;

public class SendHeaders {

    private static final String EXCHANGE_NAME = "header_logs";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            //设置交换器类型 topic
            channel.exchangeDeclare(EXCHANGE_NAME, ExchangeTypes.HEADERS,false,true,null);

            Map<String, Object> headers = new HashMap<String, Object>();
            headers.put("aaa", 01234);
            headers.put("bbb", "56789");

            AMQP.BasicProperties.Builder properties = new AMQP.BasicProperties.Builder();
            properties.headers(headers);


//            String routingKey = "rabbit.topic";
            String message = "header 首部";

            channel.basicPublish(EXCHANGE_NAME, "", properties.build(), message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '"  + "':'" + message + "'");
        }
    }

}