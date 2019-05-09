package com.tensquare.test;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "itheima")
public class Customer2 {
    @RabbitHandler

    public void showMessage(String message){
        System.out.println("itheima："+message);
    }

}
