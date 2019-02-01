package com.zeed.zeechat.usermanagement;

import com.zeed.zeechat.usermanagement.apimodel.UserSignUpResponseModel;
import com.zeed.zeechat.usermanagement.apimodel.UserSignupRequestModel;

public interface UserOperation {

    UserSignUpResponseModel signupUser(UserSignupRequestModel signupRequestModel);
}
