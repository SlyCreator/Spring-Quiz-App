package com.slycreator.springquizapp.controller;

import com.slycreator.springquizapp.dto.LoginDto;
import com.slycreator.springquizapp.entity.User;
import com.slycreator.springquizapp.response.AppResponse;
import com.slycreator.springquizapp.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/me")
    public String welcome(){
        return "You are logged In ---------";
    }

    @PostMapping("/register")
    public AppResponse register(@RequestBody User user)
    {
     return this.userService.saveUser(user);
    }

    @PostMapping("/login")
    public AppResponse login(@RequestBody LoginDto loginDTO) throws Exception {
        return this.userService.login(loginDTO);
    }

    @PostMapping("/recover_password")
    public AppResponse recoverPassword(@RequestBody String email) throws Exception {
        return this.userService.recoverPassword(email);
    }

    @PostMapping("/verify_otp")
    public AppResponse verify(@RequestBody String otp) throws Exception {
        return this.userService.verifyOTP(otp);
    }

}
