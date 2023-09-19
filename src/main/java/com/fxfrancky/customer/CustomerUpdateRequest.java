package com.fxfrancky.customer;

public record CustomerUpdateRequest(
        String name,
        String email,
        Integer age
) {}
