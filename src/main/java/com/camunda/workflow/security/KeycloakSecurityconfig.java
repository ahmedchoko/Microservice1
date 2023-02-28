package com.camunda.workflow.security;



import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;



@KeycloakConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class KeycloakSecurityconfig extends KeycloakWebSecurityConfigurerAdapter{

	@Override
	protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
		// TODO Auto-generated method stub
		return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
	}
	///delegate authentification to keycloak
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.authenticationProvider(keycloakAuthenticationProvider());
}
@Override
protected void configure(HttpSecurity http) throws Exception {
    super.configure(http);
    http.cors().and();
    http.csrf().disable();
    http.authorizeRequests().antMatchers("/camunda/**").permitAll();
    http.authorizeRequests().antMatchers("/engine-rest/**").permitAll();
    http.authorizeRequests().anyRequest().authenticated();

   
}

}

