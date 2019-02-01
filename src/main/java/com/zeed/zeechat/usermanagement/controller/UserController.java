package com.zeed.zeechat.usermanagement.controller;

import com.zeed.zeechat.usermanagement.UserOperation;
import com.zeed.zeechat.usermanagement.apimodel.UserSignUpResponseModel;
import com.zeed.zeechat.usermanagement.apimodel.UserSignupRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserOperation userOperation;

    @PostMapping("/signup")
    public UserSignUpResponseModel signup(@Validated @RequestBody UserSignupRequestModel signupRequestModel) {

        return userOperation.signupUser(signupRequestModel);

    }

}
