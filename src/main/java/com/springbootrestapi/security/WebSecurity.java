package com.springbootrestapi.security;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .httpBasic().and()
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/api/**").permitAll()
                    .antMatchers(HttpMethod.GET, "/api/**").permitAll()
                    .antMatchers(HttpMethod.DELETE, "/api/**").permitAll()
                    .antMatchers(HttpMethod.PUT, "/api/**/**").permitAll()
                    .antMatchers(HttpMethod.PATCH, "/api/**").permitAll().and()
                    .csrf().disable();
        }

    }
