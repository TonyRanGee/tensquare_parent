package com.tensquare.test;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "jingke")
public class Customer3 {
    @RabbitHandler

    public void showMessage(String message){
        System.out.println("jingke："+message);
    }

}
