package io.grumpyprogrammer.springmongodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@EnableMongoAuditing(dateTimeProviderRef = "dateTimeProvider")
@SpringBootApplication
public class SpringMongoDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMongoDemoApplication.class, args);
    }

    @Bean
    DateTimeProvider dateTimeProvider() {
        return () -> Optional.of(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS));
    }

}
