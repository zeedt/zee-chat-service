package com.zeed.zeechat.usermanagement.apimodel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class UserSignUpResponseModel {

    private String message;

    private boolean successful = false;
}
