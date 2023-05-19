package com.example.assignment.Registration;

public record UserProfileRequest(
                                 String gender,
                                 String age,
                                 String dateOfBith,
                                 String maritalStatus,
                                 String nationality,
                                 String email) {
}
