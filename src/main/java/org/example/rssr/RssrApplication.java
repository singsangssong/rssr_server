package org.example.rssr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RssrApplication {

    public static void main(String[] args) {
        SpringApplication.run(RssrApplication.class, args);
    }

}
