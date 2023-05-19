package com.example.assignment.Registration;

public record RegistrationRequest(String email,
                                  String password,
                                  String firstname,
                                  String lastname
    ) {
}
