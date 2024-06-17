package com.MySpringBootapplication.MySpringBoot_Application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
            .authorizeRequests(auth->
                auth
                    .antMatchers("/", "/login", "/public/**").permitAll()
                    .anyRequest().authenticated()
            )
            .oauth2Login(OAuth2UserRequest::defaultSuccessUrl)
            .oauth2ResourceServer(oauth2 -> oauth2.jwt());

        return http.build();
    }
}
