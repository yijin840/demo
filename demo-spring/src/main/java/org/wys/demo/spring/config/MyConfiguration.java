package org.wys.demo.spring.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wys
 * @date 2020/12/22 9:00 下午
 */
@ConfigurationProperties("my.config")
@Data
@Component
public class MyConfiguration {

    private String name;

    private Integer value;

    private String url;

    private Boolean rocketStatus;

}
