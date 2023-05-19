package com.example.assignment.services;

import com.example.assignment.Registration.RegistrationRequest;
import com.example.assignment.Registration.UserProfileRequest;
import com.example.assignment.exception.UserNotFoundException;
import com.example.assignment.model.User;
import com.example.assignment.model.VerificationToken;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getUsers();
    User registerUser (RegistrationRequest request);

    User updateUserProfile(UserProfileRequest UserProfileRequest) throws UserNotFoundException;

    Optional<User> findByEmail(String email);

    void saveUserVerificationToken(User theUser, String verificationToken);

    String validateToken(String theToken);
}
