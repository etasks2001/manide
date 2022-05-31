package com.manide.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.manide.certificado.KeyRepository;

@Configuration
public class Config {

    @Bean
    public KeyRepository getKeyRepository() {
	return new KeyRepository("./mde/x.pfx", "448006".toCharArray());
    }

}