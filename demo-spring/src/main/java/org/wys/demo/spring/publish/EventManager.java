package org.wys.demo.spring.publish;

import com.alibaba.fastjson.JSON;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wys
 * @date 2022/3/4
 * 事件管理器，统一对所有事件做一层处理
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class EventManager {

    public void doHandler() {
        log.info("[ EventManager ] applicationEventList ==> {}", JSON.toJSON(applicationEventList));
    }

}
