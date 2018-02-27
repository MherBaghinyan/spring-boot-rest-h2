package com.banking;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Gebruiker on 2/26/2018.
 */
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.banking")
@EntityScan(basePackages = "com.banking.domain")
@EnableTransactionManagement
public class ApplicationConfig {
}
