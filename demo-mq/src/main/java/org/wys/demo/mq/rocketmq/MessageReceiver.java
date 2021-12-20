//package org.wys.demo.mq.rocketmq;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
//import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
//import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
//import org.apache.rocketmq.common.message.MessageExt;
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.springframework.stereotype.Component;
//import org.springframework.util.CollectionUtils;
//
//import java.io.UnsupportedEncodingException;
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//
///**
// * @author wys
// * @date 2021/9/10
// */
//@Component
//@Slf4j
//@RocketMQMessageListener(consumerGroup = "springBootGroup", topic = "TestTopic")
//public class MessageReceiver implements RocketMQListener<String> {
//
//    @Override
//    public void onMessage(String message) {
//        log.info("收到消息，消息内容为 ====> {}", message);
//    }
//
//}
