package com.church.YPortal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF for REST APIs
                .csrf(csrf -> csrf.disable())

                // Allow all requests (for now)
//                .authorizeHttpRequests(auth -> auth
//                        .anyRequest().permitAll()
//                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll()
                        .anyRequest().authenticated()
                )

                // Enable HTTP Basic authentication
              // authentication authentication.httpBasic(Customizer.withDefaults());
                .httpBasic(Customizer.withDefaults());

        return http.build();
        }

    /**
     * This method tells Spring how to create a PasswordEncoder bean.
     *
     * A PasswordEncoder is responsible for:
     * - Hashing (encoding) plain-text passwords before saving them to the database
     * - Verifying passwords during login
     *
     * @Bean means:
     * - Spring will run this method once at startup
     * - The returned object will be managed by Spring
     * - The same instance will be reused (singleton) wherever needed
     */
    @Bean
    public PasswordEncoder passwordEncoder() {

        /*
         * BCryptPasswordEncoder is a secure password-hashing algorithm.
         * It automatically:
         * - Adds a random salt
         * - Produces a different hash for the same password every time
         * - Is slow by design (which protects against brute-force attacks)
         *
         * Spring Security will use this encoder for:
         * - Saving new user passwords
         * - Checking passwords during authentication (login)
         */
        return new BCryptPasswordEncoder();
    }


    // Needed for manual authentication later (JWT, REST login)
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}


