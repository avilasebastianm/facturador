package com.facturador.backend.security;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private Dotenv dotenv;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests.anyRequest().authenticated()
                )
                .oauth2Login(oauth2 -> oauth2
                        .clientRegistrationRepository(clientRegistrationRepository())
                );
        return http.build();
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(googleClientRegistration());
    }

    private ClientRegistration googleClientRegistration() {
       //Test prueba error error con Google_client

//        String clientId = dotenv.get("GOOGLE_CLIENT_ID");
//        String clientSecret = dotenv.get("GOOGLE_CLIENT_SECRET");
//
//        System.out.println("GOOGLE_CLIENT_ID from .env: [" + clientId + "]");
//        System.out.println("GOOGLE_CLIENT_SECRET from .env: [" + clientSecret + "]");
//
//        if (clientId == null || clientId.isEmpty() || clientSecret == null || clientSecret.isEmpty()) {
//            System.err.println("Error: GOOGLE_CLIENT_ID or GOOGLE_CLIENT_SECRET is missing or empty.");
//            return null;
//        }




        return ClientRegistration.withRegistrationId("google")
                .clientId(dotenv.get("GOOGLE_CLIENT_ID"))
                .clientSecret(dotenv.get("GOOGLE_CLIENT_SECRET"))
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUri("http://localhost:8080")
               // .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
                .scope("openid", "profile", "email")
                .authorizationUri("https://accounts.google.com/o/oauth2/v2/auth")
                .tokenUri("https://www.googleapis.com/oauth2/v4/token")
                .userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
                .userNameAttributeName("name")
                .clientName("Google")
                .build();
    }
}