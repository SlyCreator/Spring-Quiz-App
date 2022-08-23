package com.slycreator.springquizapp.service.Impl;

import com.slycreator.springquizapp.dto.LoginDto;
import com.slycreator.springquizapp.entity.User;
import com.slycreator.springquizapp.repository.UserRepository;
import com.slycreator.springquizapp.response.AppResponse;
import com.slycreator.springquizapp.security.JwtUtil;
import com.slycreator.springquizapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    JwtUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }

    @Override
    public AppResponse saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        return AppResponse.ok().code(201)
                .data(map).message("Registration successful");
    }

    public AppResponse login(LoginDto loginDTO) throws Exception {
        try {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDTO.getEmail(), loginDTO.getPassword()
                    )
            );
        } catch (Exception ex) {
            throw new Exception("Email or Password is invalid");
        }
        String Bearer = jwtUtil.generateToken(loginDTO.getEmail());
        Map<String, Object> map = new HashMap<>();
        map.put("token", Bearer);
        return AppResponse.ok().data(map).message("Login successfully");
    }

    public User AuthUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();
        User user = userRepository.findByEmail(email);
        return user;
    }

    public AppResponse recoverPassword(String email) {
        return null;
    }

    public AppResponse verifyOTP(String otp) {
        return null;
    }


}
