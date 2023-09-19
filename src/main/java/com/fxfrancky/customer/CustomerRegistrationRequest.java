package com.fxfrancky.customer;

public record CustomerRegistrationRequest(
        String name,
        String email,
        Integer age
) {
}
