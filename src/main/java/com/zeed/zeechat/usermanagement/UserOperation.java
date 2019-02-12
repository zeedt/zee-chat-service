package com.zeed.zeechat.usermanagement;

import com.zeed.zeechat.entities.User;
import com.zeed.zeechat.exception.ZeeChatException;
import com.zeed.zeechat.usermanagement.apimodel.UserSignUpResponseModel;
import com.zeed.zeechat.usermanagement.apimodel.UserSignupRequestModel;

public interface UserOperation {

    UserSignUpResponseModel signupUser(UserSignupRequestModel signupRequestModel);

    User findUserByUsername(String username);

    User findUserByUsernameOrEmail(String username, String email) throws ZeeChatException;
}
