package com.era.miqrosheet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("**.mapper")
public class MiqroSheetApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiqroSheetApplication.class, args);
    }
}
