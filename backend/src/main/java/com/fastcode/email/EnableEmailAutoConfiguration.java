package com.fastcode.email;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.content.fs.config.EnableFilesystemStores;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.fastcode.email")
@EntityScan(basePackages = {"com.fastcode.email.emailapi.domain.model", "com.fastcode.email.emailbuilder.domain.model"})
@EnableJpaRepositories(basePackages = {"com.fastcode.email","org.springframework.versions"})
@EnableFilesystemStores
public class EnableEmailAutoConfiguration {
}
