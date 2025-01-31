package com.valleon.hngstage0backendtask2024.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class PublicApiController {

    @GetMapping("/")
    public Map<String, String> getInfo() {
        Map<String, String> response = new HashMap<>();
        response.put("email", "val.ekechukwu@gmail.com");
        response.put("current_datetime", DateTimeFormatter.ISO_INSTANT.format(Instant.now().atOffset(ZoneOffset.UTC)));
        response.put("github_url", "https://github.com/valleon6/hng-stage-0-backend-task-2024.git");

        return response;
    }
}
