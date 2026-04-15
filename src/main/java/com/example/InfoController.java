package com.example;

import java.time.Instant;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @Value("${app.version:1.0.0}")
    private String version;

    @Value("${app.name:gh-actions-app}")
    private String name;

    @GetMapping("/info")
    public Map<String, String> info() {
        return Map.of(
                "app", name,
                "version", version,
                "java", System.getProperty("java.version"),
                "timestamp", Instant.now().toString()
        );
    }
}
