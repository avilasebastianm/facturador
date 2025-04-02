package com.facturador.backend.controller;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/login/oauth2/code/google")
    public String handleGoogleCallback(@RegisteredOAuth2AuthorizedClient("google") OAuth2AuthorizedClient authorizedClient) {
        // Aquí puedes procesar el authorizedClient y obtener el token de acceso.

        // Luego, puedes utilizar el token de acceso para obtener información del usuario de Google.
        // Y finalmente, implementar la lógica de autenticación en tu aplicación.
        return "Login successful. Access Token: " + authorizedClient.getAccessToken().getTokenValue();
    }
}