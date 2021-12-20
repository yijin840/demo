//package org.wys.demo.mq.rocketmq;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author wys
// * @date 2021/9/13
// */
//@RestController
//@RequiredArgsConstructor
//public class RocketMQController {
//
//    private final MessageSender sender;
//
//    @RequestMapping("/sendMessage")
//    public String sendMessage() {
//        sender.sender("TestTopic", "你好啊");
//        return "SUCCESS";
//    }
//
//    @RequestMapping("/test")
//    public String test() {
//        return "true";
//    }
//}
