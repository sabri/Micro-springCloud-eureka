package com.example.movieinfoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MovieInfoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieInfoApiApplication.class, args);
    }

}
