package com.example.assignment.controller;

import com.example.assignment.Registration.RegistrationRequest;
import com.example.assignment.Registration.UserProfileRequest;
import com.example.assignment.dto.SignupDto;
import com.example.assignment.event.RegistrationCompleteEvent;
import com.example.assignment.model.User;
import com.example.assignment.model.VerificationToken;
import com.example.assignment.repository.UsersRepository;
import com.example.assignment.repository.VerificationTokenRepository;
import com.example.assignment.services.UserService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserController {

     private final UserService userService;

     private final VerificationTokenRepository tokenRepository;
     private final ApplicationEventPublisher publisher;
     @PostMapping("/signup")
     public String registerUser(@RequestBody RegistrationRequest registrationRequest, final HttpServletRequest request){
         User user = userService.registerUser(registrationRequest);
         publisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(request)));
         return "Success! Please check your email to complete registration";
     }
     @GetMapping("/verifyEmail")
     public String verifyEmail(@RequestParam("token") String token){
         System.out.println("=========================================");
         VerificationToken theToken = tokenRepository.findByToken(token);
         if(theToken.getUser().isEnabled()){
             return "This account has already been verified, please login";
         }
         String verificationResult = userService.validateToken(token);
         if(verificationResult.equalsIgnoreCase("valid")){
             return "Email verified successfully";
         }
         return "Invalid verification token";
     }

//    @PostMapping("/updateProfile")
//    public String updateProfile(@RequestBody UserProfileRequest userProfileRequest){
//        User user = userService.registerUser(userProfileRequest);
//        if(theToken.getUser().isEnabled()){
//            return "This account has already been verified, please login";
//        }
//        String verificationResult = userService.validateToken(token);
//        if(verificationResult.equalsIgnoreCase("valid")){
//            return "Email verified successfully";
//        }
//        return "Invalid verification token";
//    }
     public String applicationUrl(HttpServletRequest request){
         return "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
     }

}
