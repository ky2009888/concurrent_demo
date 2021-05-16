package com.ky2009666.apps;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Lenovo
 */
@SpringBootApplication
@Slf4j
public class ConcurrentDemoApplication {

    public static void main(String[] args) {
        log.info("---------------------------");
        SpringApplication.run(ConcurrentDemoApplication.class, args);
    }

}
