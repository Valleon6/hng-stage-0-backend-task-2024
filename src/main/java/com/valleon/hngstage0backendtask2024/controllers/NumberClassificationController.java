package com.valleon.hngstage0backendtask2024.controllers;

import com.valleon.hngstage0backendtask2024.services.NumberClassificationService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class NumberClassificationController {

    private final NumberClassificationService classificationService;

    public NumberClassificationController(NumberClassificationService classificationService) {
        this.classificationService = classificationService;
    }

    @GetMapping("/classify-number")
    public Object classifyNumber(@RequestParam String number) {
        return classificationService.classifyNumber(number);
    }
}