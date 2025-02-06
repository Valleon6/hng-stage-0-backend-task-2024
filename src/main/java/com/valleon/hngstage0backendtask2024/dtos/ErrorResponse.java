package com.valleon.hngstage0backendtask2024.dtos;

public class ErrorResponse {
    private String number;
    private boolean error;

    public ErrorResponse(String number) {
        this.number = number;
        this.error = true;
    }

    public String getNumber() {
        return number;
    }

    public boolean isError() {
        return error;
    }
}