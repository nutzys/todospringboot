package com.todolist.todolistmanager.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

import org.springframework.security.core.userdetails.User;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

    private BCryptPasswordEncoder passEncoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(authorizeRequests -> authorizeRequests
            .antMatchers(HttpMethod.DELETE, "/delete/*/contact").hasRole("ADMIN")
            .antMatchers(HttpMethod.POST).hasAnyRole("ADMIN", "USER")
            .antMatchers(HttpMethod.GET).permitAll()
            .anyRequest().authenticated())
        .httpBasic(Customizer.withDefaults())
        .sessionManagement(sessionManagement -> 
            sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }

    @Bean
    public UserDetailsService users(){
        UserDetails user = User.builder()
            .username("user")
            .password(passEncoder.encode("user-pass"))
            .build();
        return new InMemoryUserDetailsManager(user);
    }
}
