package com.bezkoder.springjwt.security.Authentication;

import com.bezkoder.springjwt.security.services.UserDetailsImpl;
import com.bezkoder.springjwt.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String pass = authentication.getCredentials().toString();
        UserDetailsImpl userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(name);
        if (userDetails == null) {
            throw new UsernameNotFoundException("Không có tài khoản trùng khớp");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode(pass));
        System.out.println(userDetails.getPassword());
        if (!encoder.matches(pass,userDetails.getPassword())) {
            throw new UsernameNotFoundException("Mật khẩu không đúng");
        }


        return new UsernamePasswordAuthenticationToken(userDetails, pass, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
