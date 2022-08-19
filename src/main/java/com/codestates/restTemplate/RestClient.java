package com.codestates.restTemplate;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class RestClient {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("worldtimeapi.org")
//                .port(80)
                .path("/api/timezone/{continents}/{city}")
                .encode()
                .build();
        URI uri = uriComponents.expand("Asia", "Seoul").toUri();

        ResponseEntity<WorldTime> response = restTemplate.exchange(uri,
                HttpMethod.GET,
                null,
                WorldTime.class);
        System.out.println("getDatetime = " + response.getBody().getDatetime());
        System.out.println("getTimezone = " + response.getBody().getTimezone());
        System.out.println("getDay_of_week = " + response.getBody().getDay_of_week());
        System.out.println("getStatusCode = " + response.getStatusCode());
        System.out.println("getStatusCodeValue = " + response.getStatusCodeValue());
        System.out.println("entrySet = " + response.getHeaders().entrySet());
    }
}
