package com.bezkoder.springjwt.validates;

import com.bezkoder.springjwt.entities.ERole;
import com.bezkoder.springjwt.entities.Role;
import com.bezkoder.springjwt.entities.User;
import com.bezkoder.springjwt.exceptions.SignUpException;
import com.bezkoder.springjwt.exceptions.UserValidatorException;
import com.bezkoder.springjwt.payload.request.SignupRequest;
import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ControllerAdvice
public class SignUpValidator {
    private static final Logger logger = LoggerFactory.getLogger(SignUpValidator.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public void validate(SignupRequest user) throws UserValidatorException {
        List<String> errors = new ArrayList<>();
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new UserValidatorException("Tên tài khoản đã được sử dụng");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserValidatorException("Email đã được sử dụng");
        }
    }
    public Set<Role> validateRole(SignupRequest user) throws UserValidatorException{
        Set<String> strRoles = user.getRole();
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new UserValidatorException("Không tìm thấy quyền "));
            roles.add(userRole);
        } else {
            for (String role : strRoles) {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new UserValidatorException("Không tìm thấy quyền "));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new UserValidatorException("Không tìm thấy quyền "));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new UserValidatorException("Không tìm thấy quyền "));
                        roles.add(userRole);
                }
            }
        }
        return roles;
    }
}
