package com.rabbitmq._4_direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import com.rabbitmq.client.BuiltinExchangeType;

public class SendDirect {

    private static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

            String severity = "info";
            String severity2 = "debug";
            String message = "direct 直接交换器";
            String message2 = "direct2 直接交换器";

//            发送消息的路由健（第二个参数）
            channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes("UTF-8"));
//            channel.basicPublish(EXCHANGE_NAME, severity2, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + severity + "':'" + message + "'");
        }
    }



}
