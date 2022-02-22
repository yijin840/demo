package org.wys.demo.geteway.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author wys
 * @date 2022/2/17
 */
@Component
@Slf4j
public class DynamicGatewayRouteConfig implements ApplicationEventPublisherAware {

    private String dataId = "gateway-router";

    private String group = "DEFAULT_GROUP";

    @Value("${spring.cloud.nacos.discovery.server-addr}")
    private String serverAddr;

    @Autowired
    private RouteDefinitionWriter routeDefinitionWriter;

    private ApplicationEventPublisher applicationEventPublisher;

    private static final List<String> ROUTE_LIST = new ArrayList<String>();

    @PostConstruct
    public void dynamicRouteByNacosListener() {
        try {
            log.info("[ DynamicGatewayRouteConfig ] dynamicRouteByNacosListener start.");
            ConfigService configService = NacosFactory.createConfigService(serverAddr);
            configService.getConfig(dataId, group, 5000);
            configService.addListener(dataId, group, new Listener() {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    clearRoute();
                    try {
                        List<RouteDefinition> gatewayRouteDefinitions = JSONObject.parseArray(configInfo, RouteDefinition.class);
                        log.info("[ DynamicGatewayRouteConfig ] gateway route definitions data : {}", JSONObject.toJSON(gatewayRouteDefinitions));
                        for (RouteDefinition routeDefinition : gatewayRouteDefinitions) {
                            addRoute(routeDefinition);
                        }
                        publish();
                        log.info("[ DynamicGatewayRouteConfig ] dynamicRouteByNacosListener publish success.");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public Executor getExecutor() {
                    return null;
                }
            });
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }

    private void clearRoute() {
        for (String id : ROUTE_LIST) {
            this.routeDefinitionWriter.delete(Mono.just(id)).subscribe();
        }
        ROUTE_LIST.clear();
    }

    private void addRoute(RouteDefinition definition) {
        try {
            routeDefinitionWriter.save(Mono.just(definition)).subscribe();
            ROUTE_LIST.add(definition.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void publish() {
        this.applicationEventPublisher.publishEvent(new RefreshRoutesEvent(this.routeDefinitionWriter));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
