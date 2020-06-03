package org.rhb.vhr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("org.rhb.vhr.mapper")

public class Vhr1BackApplication {
    public static void main(String[] args) {
        SpringApplication.run(Vhr1BackApplication.class, args);
    }

}
