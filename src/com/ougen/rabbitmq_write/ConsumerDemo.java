package com.ougen.rabbitmq_write;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author:ougen
 * @date:2018/9/321:56
 */
public class ConsumerDemo {
    private static ConnectionFactory connectionFactory = new ConnectionFactory();
    static{
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
    }

    public static void main(String[] args) {
        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(Configs.TTL_QUEUE,true,false,false,null);
            Consumer consumer = new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(" [x] Received '" + message + "'");
                    long enveloped = envelope.getDeliveryTag();
                    channel.basicAck(enveloped,false);

                }
            };
            while (true) {
                channel.basicConsume(Configs.TTL_QUEUE, consumer);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
