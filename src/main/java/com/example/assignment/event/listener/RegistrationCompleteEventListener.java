package com.example.assignment.event.listener;

import com.example.assignment.event.RegistrationCompleteEvent;
import com.example.assignment.model.User;
import com.example.assignment.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    private final UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //Get newly created User
        User theUser = event.getUser();
        //Create Verification token for the user
        String verificationToken = UUID.randomUUID().toString();
        //save verification token
        userService.saveUserVerificationToken(theUser, verificationToken);
        //build verification url to be sent to the user
        String url = event.getApplicationUrl()+"/auth/verifyEmail?token="+verificationToken;
        //send email
        log.info("Click the link for verification: {}", url);
    }
}
