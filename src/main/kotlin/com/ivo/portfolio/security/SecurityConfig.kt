package com.ivo.portfolio.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {

        http
            .csrf { it.disable() }
            .authorizeHttpRequests {
//                it.requestMatchers(
//                    "/",
//                    "/api/**",
//                    "/swagger-ui/**",
//                    "/v3/api-docs/**",
//                    "/actuator/**",
//                    "/h2-console/**"
//                ).permitAll()

               it.anyRequest().permitAll()
            }
//            .headers {
//                it.frameOptions { frame -> frame.disable() }
//            }

        return http.build()
    }
}