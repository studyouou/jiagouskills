package com.ougen.rabbitmq_write;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author:ougen
 * @date:2018/9/221:49
 */
public class ProductorDemo {
    private static ConnectionFactory connectionFactory = new ConnectionFactory();
    static {
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
    }
    public static void main(String[] args) {
        yanchiMessage();
    }

    private static void yanchiMessage(){
        try {

            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("x-dead-letter-exchange",Configs.TTL_EXCHANGE);
            map.put("x-message-ttl",60000);
            channel.exchangeDeclare(Configs.ORDER_EXCHANGE,BuiltinExchangeType.DIRECT,true);
            channel.queueDeclare(Configs.ORDER_QUEUE_NAME,true,false,false,map);
            channel.queueBind(Configs.ORDER_QUEUE_NAME,Configs.ORDER_EXCHANGE,Configs.ROUTKEY1);

            channel.queueDeclare(Configs.TTL_QUEUE,true,false,false,null);
            channel.exchangeDeclare(Configs.TTL_EXCHANGE,BuiltinExchangeType.DIRECT,true);
            channel.queueBind(Configs.TTL_QUEUE,Configs.TTL_EXCHANGE,Configs.ROUTKEY1);

            for (int i = 0 ; i<100;i++){
                channel.basicPublish(Configs.ORDER_EXCHANGE,Configs.ROUTKEY1,null,("延迟队列消息"+i).getBytes());
                Thread.sleep(1000);
            }
            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void sentMessageByDirect(){
        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(Configs.DERICT_EXCHANGE, BuiltinExchangeType.DIRECT,true);
            channel.queueDeclare(Configs.QUEUE_NAME,true,false,false,null);
            channel.queueBind(Configs.QUEUE_NAME,Configs.DERICT_EXCHANGE,Configs.ROUTKEY1);
            channel.basicPublish(Configs.DERICT_EXCHANGE,Configs.ROUTKEY1,null,"hello rabbitmq".getBytes());
            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
    private static void sendMessageBySimple(){
        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(Configs.QUEUE_NAME,true,false,false,null);
            for (int i = 0 ; i<1000 ; i++){
                channel.basicPublish("",Configs.QUEUE_NAME,false,false,null,("简单的队列--"+i).getBytes());
            }

            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void sentMessageByFaut(){
        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(Configs.FAULT_EXCHANGE, BuiltinExchangeType.FANOUT,true);
            channel.queueDeclare(Configs.QUEUE_NAME,true,false,false,null);
            channel.queueBind(Configs.QUEUE_NAME,Configs.FAULT_EXCHANGE,Configs.ROUTKEY1);
            channel.basicPublish(Configs.FAULT_EXCHANGE,Configs.ROUTKEY1,null,"hello fault".getBytes());
            System.out.println("发送成功 hello fault");
            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }

    private static void sendMessageByTopic(){
        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(Configs.TOPIC_EXCHANGE,BuiltinExchangeType.TOPIC,true);
            channel.queueDeclare(Configs.QUEUE_NAME,true,false,false,null);
            channel.queueBind(Configs.QUEUE_NAME,Configs.TOPIC_EXCHANGE,"*.orange");
            channel.basicPublish(Configs.TOPIC_EXCHANGE,"hello.orange",null,"hello topic".getBytes());
            System.out.println("消息发送成功 hello orange");
            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }
}
