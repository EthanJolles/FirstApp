package com.jolles.spring.security.firstapp;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.Arrays;

public class MyAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String pass = authentication.getCredentials().toString();

        if ("tom".equals(userName) && "cruise".equals(pass)) {
            return new UsernamePasswordAuthenticationToken(userName, pass, Arrays.asList());
        } else {
            throw new BadCredentialsException("Invalid Username or Password");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
