package org.rhb.vhr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
@Configuration
@EnableWebSocketMessageBroker
/*开启消息代理*/
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    /*注册连接点*/
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        /*允许前端所有域发起请求*/
        registry.addEndpoint("/ws/ep").setAllowedOrigins("*").withSockJS();
/*以ws为前缀跟普通http请求区分开来*/
    }
    /*消息代理转发*/
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        registry.enableSimpleBroker("/queue");

    }
}
