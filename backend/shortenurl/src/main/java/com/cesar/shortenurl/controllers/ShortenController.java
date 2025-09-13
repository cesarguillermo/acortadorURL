package com.cesar.shortenurl.controllers;

import com.cesar.shortenurl.service.ShortenServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController

@CrossOrigin(origins= "http://localhost:5173")
public class ShortenController {

    private final ShortenServiceImpl shortenService;

    public  ShortenController (ShortenServiceImpl shortenService ) {
        this.shortenService = shortenService;
    }

    @PostMapping("/api/shorten")
    public ResponseEntity<?> shorten(@RequestBody Map<String,String> body ) {
        String url = body.get("url");
        if (url.isBlank()) {
            return ResponseEntity.badRequest().body("URL is required");
        }
        String slugid = shortenService.shortenUrl(url);
        String shortUrl = "http://localhost:8080/" + slugid;

        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("shortUrl",shortUrl));
    }

    @GetMapping("/{slugid}")
    public ResponseEntity<?> getUrl (@PathVariable String slugid) {
        String url = shortenService.getOriginalURL(slugid);

        if (url == null) {
            ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(302).location(URI.create(url)).build();

    }
}
