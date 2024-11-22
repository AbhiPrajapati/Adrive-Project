package com.adrive.ADrive.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebConfig {

    @Autowired
    private UserDetailsService userDetailService;

    @Autowired
    private JWTFilter JwtFilter;
    
    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
       return httpSecurity.csrf(customizer -> customizer.disable())
               .authorizeHttpRequests(req -> req.requestMatchers("register","login").permitAll().
                               anyRequest().authenticated())
               //.formLogin(Customizer.withDefaults())
               .httpBasic(Customizer.withDefaults())
               .logout(Customizer.withDefaults())
               .addFilterBefore(JwtFilter, UsernamePasswordAuthenticationFilter.class)
               .build();
    }

//    @Bean
//    public UserDetailsService getInMemoryUsers()
//    {
//        List<UserDetails> usersList = Arrays.asList(
//                 User.withDefaultPasswordEncoder().username("Abhishek").password("1234").roles("ADMIN").build(),
//                User.withDefaultPasswordEncoder().username("Ananya").password("1234").roles("FACULTY").build()
//        ) ;
//        return new  (usersList);
//    }

    @Bean
    public AuthenticationProvider getAuthenticationProvider()
    {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailService);
        return daoAuthenticationProvider;
    }

    @Bean
    public AuthenticationManager getAuthenticationManager(AuthenticationConfiguration conf) throws Exception {
        return  conf.getAuthenticationManager();
    }

}
