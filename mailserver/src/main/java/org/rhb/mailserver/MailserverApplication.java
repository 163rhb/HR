package org.rhb.mailserver;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class MailserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailserverApplication.class, args);

    }

    @Bean
    Queue queue(){
        System.out.println("here");
        System.out.println("来这里！！！！！！");
        return new Queue("rhb.mail");
    }

}
