package com.bezkoder.springjwt.services.Audit;


import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.LinkedList;
import java.util.Optional;

class AuditorAwareImpl implements AuditorAware<Long> {
    @Autowired
    private UserRepository userRepository;

    public Optional<Long> getCurrentAuditor() {
        Optional<UserDetailsImpl> userDetails = Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getPrincipal)
                .map(UserDetailsImpl.class::cast);


        return Optional.of(userDetails.get().getId());
    }
}