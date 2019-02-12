package com.zeed.zeechat.usermanagement.controller;

import com.zeed.zeechat.entities.User;
import com.zeed.zeechat.exception.ZeeChatException;
import com.zeed.zeechat.usermanagement.UserOperation;
import com.zeed.zeechat.usermanagement.apimodel.UserSignUpResponseModel;
import com.zeed.zeechat.usermanagement.apimodel.UserSignupRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserOperation userOperation;

    @PostMapping("/signup")
    public UserSignUpResponseModel signup(@Validated @RequestBody UserSignupRequestModel signupRequestModel) {

        return userOperation.signupUser(signupRequestModel);

    }

    @GetMapping("/fetch-user-details")
    public User fetchUserDetails(@RequestParam("username") String username) {
        return userOperation.findUserByUsername(username);
    }

    @GetMapping("/fetch-user-details-by-email-or-username")
    public User fetchUserDetailsByEmailOrUsername(@RequestParam("username") String username,@RequestParam("email") String email ) throws ZeeChatException {
        return userOperation.findUserByUsernameOrEmail(username, email);
    }

    @GetMapping("")
    public Boolean ping(){
        return true;
    }

}
