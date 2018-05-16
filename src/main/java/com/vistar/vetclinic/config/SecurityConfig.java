package com.vistar.vetclinic.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("qwe").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("user").password("qwe").roles("USER");
        auth.inMemoryAuthentication().withUser("staff").password("qwe").roles("STAFF");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers( "/user").access("hasRole('ADMIN') or hasRole('USER') or hasRole('STAFF')");
        http.authorizeRequests()
                .and().formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/j_spring_security_check")
                .defaultSuccessUrl("/pets")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password");
    }
}
