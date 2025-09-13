package com.cesar.shortenurl.service;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Service
public class ShortenServiceImpl {

    private final Map<String, String> store = new ConcurrentHashMap<>();
    private  final SecureRandom random = new SecureRandom();

    /*
        Genera un slug y guarda la URL
     */
    public String shortenUrl(String url ) {
        String sludid = generateId();
        store.put(sludid,url);
        return sludid;

    }

    public String getOriginalURL(String slugid) {
        return store.get(slugid);
    }


    // Generador de ID aleatorios
    private String generateId() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(6);
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }

        return sb.toString();
    }

}
