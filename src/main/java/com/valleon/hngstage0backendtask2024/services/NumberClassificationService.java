package com.valleon.hngstage0backendtask2024.services;

import com.valleon.hngstage0backendtask2024.dtos.ErrorResponse;
import com.valleon.hngstage0backendtask2024.dtos.NumberClassificationResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class NumberClassificationService {

    private final RestTemplate restTemplate;

    public NumberClassificationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Object classifyNumber(String numberStr) {
        try {
            int number = Integer.parseInt(numberStr);
            boolean isPrime = isPrime(number);
            boolean isPerfect = isPerfect(number);
            List<String> properties = getProperties(number);
            int digitSum = getDigitSum(number);
            String funFact = getFunFact(number);

            return new NumberClassificationResponse(number, isPrime, isPerfect, properties, digitSum, funFact);
        } catch (NumberFormatException e) {
            return new ErrorResponse(numberStr);
        }
    }

    private boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    private boolean isPerfect(int number) {
        int sum = 1;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                sum += i;
                if (i != number / i) sum += number / i;
            }
        }
        return sum == number && number != 1;
    }

    private List<String> getProperties(int number) {
        List<String> properties = new ArrayList<>();
        if (isArmstrong(number)) properties.add("armstrong");
        properties.add(number % 2 == 0 ? "even" : "odd");
        return properties;
    }

    private boolean isArmstrong(int number) {
        int sum = 0, temp = number, digits = String.valueOf(number).length();
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp /= 10;
        }
        return sum == number;
    }

    private int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    private String getFunFact(int number) {
        String url = "http://numbersapi.com/" + number + "/math";
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            return "Could not retrieve a fun fact at this time.";
        }
    }
}