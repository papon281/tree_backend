package app.binary.tree.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable() // Disable CSRF for simplicity; enable in production if necessary
                .cors() // Enable CORS
                .and()
                .authorizeRequests()
                .antMatchers("/binary_tree/**", "/swagger-ui/**", "/v3/api-docs/**")
                .permitAll() // No authentication required for these endpoints
                .anyRequest().authenticated(); // Require authentication for other endpoints

        return httpSecurity.build();
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // Allow cookies and credentials
        config.addAllowedOrigin("http://localhost:3000"); // Allow requests from React App
        config.addAllowedMethod("*"); // Allow all HTTP methods (GET, POST, PUT, DELETE, etc.)
        config.addAllowedHeader("*"); // Allow all headers

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // Apply CORS settings to all endpoints

        return new CorsFilter(source);
    }
}