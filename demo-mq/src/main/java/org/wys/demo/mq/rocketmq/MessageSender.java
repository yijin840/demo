//package org.wys.demo.mq.rocketmq;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.rocketmq.client.exception.MQBrokerException;
//import org.apache.rocketmq.client.exception.MQClientException;
//import org.apache.rocketmq.client.producer.SendResult;
//import org.apache.rocketmq.remoting.exception.RemotingException;
//import org.apache.rocketmq.spring.core.RocketMQTemplate;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.stereotype.Component;
//
///**
// * @author wys
// * @date 2021/9/10
// */
//@Component
//@RequiredArgsConstructor
//@Slf4j
//public class MessageSender {
//
//    private final RocketMQTemplate rocketMQTemplate;
//
//    public void sender(String topic, String content) {
//        Message<String> message = MessageBuilder.withPayload(content).build();
//        SendResult sendResult = rocketMQTemplate.syncSend(topic, content);
//        log.info("sendResult ===> {}", sendResult);
//        log.info("消息发送成功， 内容 ====> {}", message);
//    }
//
//}
