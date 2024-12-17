package com.adrive.ADrive.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private UserDetailsService userDetailService;

    @Autowired
    private JWTFilter JwtFilter;
    
    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
       return  http.csrf(csrf -> csrf.disable()) // Disable CSRF protection
               .authorizeHttpRequests(auth -> auth
                       .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() // Allow OPTIONS requests
                       .requestMatchers("/register", "/login").permitAll() // Allow access to these endpoints
                       .anyRequest().authenticated() // All other requests need authentication
               )
               .logout(logout -> logout.permitAll()) // Configure logout
               .addFilterBefore(JwtFilter, UsernamePasswordAuthenticationFilter.class) // Add your JWT filter
               .build();
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allow all endpoints
                .allowedOrigins("http://localhost:5173") // Adjust according to your React app's URL
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow these methods
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true); // Allow credentials if needed
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
