package com.buster;

import com.buster.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
@EnableWebMvc
@EntityScan(basePackages = "com.buster.models")
public class BusterApplication {
    @Autowired
    public ReportRepository reportRepository;

    public static void main(String[] args) {
        SpringApplication.run(BusterApplication.class, args);
    }
}
