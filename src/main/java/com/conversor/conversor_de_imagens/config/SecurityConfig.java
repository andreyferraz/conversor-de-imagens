package com.conversor.conversor_de_imagens.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private static final String LOGIN_URL = "/login";
    @Value("${app.security.password}")
    private String loginPassword;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
                        http.authorizeHttpRequests(authorize -> authorize
                                .requestMatchers( LOGIN_URL)
                                .permitAll()
                                .requestMatchers("/converter/**")
                                .authenticated()
                                .requestMatchers("/converter/**").hasRole("ADMIN")
                                .anyRequest().authenticated())

                                .formLogin(form -> form
                                                .loginPage(LOGIN_URL)
                                                .defaultSuccessUrl("/converter", true)
                                                .permitAll())
                                .csrf(AbstractHttpConfigurer::disable);
                return http.build();
    }

        @Bean
        public UserDetailsService userDetailsService() {
                UserDetails user = User.withUsername("admin")
                                .password(passwordEncoder().encode(loginPassword))
                                .roles("ADMIN")
                                .build();

                return new InMemoryUserDetailsManager(user);
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }
}
