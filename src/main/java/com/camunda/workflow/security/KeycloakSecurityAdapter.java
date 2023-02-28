package com.camunda.workflow.security;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakSecurityAdapter {
	@Bean
	public KeycloakSpringBootConfigResolver KeycloakConfigResolver() {
	     return new KeycloakSpringBootConfigResolver();
	}
}
