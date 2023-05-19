package com.example.assignment.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class JwtUserDetails implements UserDetails {

    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    // Implement the remaining methods from UserDetails interface
    // ...

    @Override
    public boolean isAccountNonExpired() {
        return true; // Modify this based on your account expiration logic
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Modify this based on your account locking logic
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Modify this based on your credentials expiration logic
    }

    @Override
    public boolean isEnabled() {
        return true; // Modify this based on your account enablement logic
    }
}