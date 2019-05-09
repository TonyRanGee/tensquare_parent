package com.tensquare.test;


import com.tensquare.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MyTest {


    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void testSend(){
        rabbitTemplate.convertAndSend("itcast","我要红包"); }


    /**
     *
     */
    @Test
    public void testSend2() {
        rabbitTemplate.convertAndSend("zhuanzhi", "", "分裂模式");
    }
}

