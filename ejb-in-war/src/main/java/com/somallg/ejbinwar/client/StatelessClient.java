package com.somallg.ejbinwar.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Created by somallg on 11/21/2014.
 */
public class StatelessClient {

    public static void main(String[] args) {
        final String url = "http://localhost:8080/ejb-in-war/stateless";
        final RestTemplate restTemplate = new RestTemplate();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

                    System.out.print(responseEntity.getBody());
                }
            }).start();
        }
    }
}
