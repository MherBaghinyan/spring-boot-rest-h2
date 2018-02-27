package com.banking.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Gebruiker on 2/27/2018.
 */
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.banking.*")
@EntityScan(basePackages = "com.banking.domain")
@PropertySource("application-test.properties")
public class H2JpaConfig {
}
