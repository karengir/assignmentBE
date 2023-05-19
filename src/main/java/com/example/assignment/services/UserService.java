package com.example.assignment.services;

import com.example.assignment.Registration.RegistrationRequest;
import com.example.assignment.Registration.UserProfileRequest;
import com.example.assignment.exception.UserAlreadyExistsException;
import com.example.assignment.exception.UserNotFoundException;
import com.example.assignment.model.User;
import com.example.assignment.model.VerificationToken;
import com.example.assignment.repository.UsersRepository;
import com.example.assignment.repository.VerificationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    private final VerificationTokenRepository tokenRepository;
    @Override
    public List<User> getUsers() {
        return usersRepository.findAll();
    }

    @Override
    public User registerUser(RegistrationRequest request) {

            Optional<User> user = this.findByEmail(request.email());
            if(user.isPresent()){
                throw new UserAlreadyExistsException("User with email " + request.email() + " already exist");
            }
            var newUser = new User();
            newUser.setFirstName(request.firstname());
            newUser.setLastName(request.lastname());
            newUser.setEmail(request.email());
            newUser.setPassword(passwordEncoder.encode(request.password()));
            System.out.println(newUser.getPassword());
            return usersRepository.save(newUser);

    }

    @Override
    public User updateUserProfile(UserProfileRequest UserProfileRequest) throws UserNotFoundException {
        return null;
    }

//    @Override
//    public User updateUserProfile(UserProfileRequest UserProfileRequest) throws UserNotFoundException {
//
//        Optional<User> user = this.findByEmail(UserProfileRequest.email());
//        if(!user.isPresent()){
//            throw new UserNotFoundException("User with email " + UserProfileRequest.email() + " does not exist");
//        }
//        User newUser = new User();
//        if(user.isPresent()){
//            newUser = user;
//        }
//        user.
//        user.setAge(UserProfileRequest.age());
//        newUser.setDateOfBirth(UserProfileRequest.dateOfBith());
//        newUser.setGender(UserProfileRequest.gender());
//        System.out.println(newUser.getPassword());
//        return usersRepository.save(newUser);
//
//    }

//    public User updateUser( User updatedUser) {
//        User existingUser = usersRepository.findByEmail(updatedUser.getId()).orElse(null);
//
//        if (existingUser != null) {
//            // Update the properties of the existingUser object with the values from updatedUser
//            existingUser.setAge(updatedUser.getName());
//            existingUser.setEmail(updatedUser.getEmail());
//            // Update other properties as needed
//
//            // Save the updated user to the database
//            return usersRepository.save(existingUser);
//        } else {
//            // Handle the case where the user does not exist
//            throw new NoSuchElementException("User not found");
//        }
//    }
    @Override
    public Optional<User> findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    @Override
    public void saveUserVerificationToken(User theUser, String token) {
        var verificationToken = new VerificationToken(token, theUser);
        tokenRepository.save(verificationToken);
    }

    @Override
    public String validateToken(String theToken) {
        VerificationToken token = tokenRepository.findByToken(theToken);
        if(token == null){
            return "Invalid verification Token";
        }
        User user = token.getUser();
        Calendar calendar = Calendar.getInstance();
        if((token.getExpirationTime().getTime() - calendar.getTime().getTime()) <= 0){
            tokenRepository.delete(token);
            return "Token already expired";
        }
        user.setEnabled(true);
        usersRepository.save(user);
        return "valid";
    }
}
