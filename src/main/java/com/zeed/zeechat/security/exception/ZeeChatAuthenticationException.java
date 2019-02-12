package com.zeed.zeechat.security.exception;

import org.springframework.security.core.AuthenticationException;

public class ZeeChatAuthenticationException extends AuthenticationException {


    public ZeeChatAuthenticationException(String message) {
        super(message);
    }

    public ZeeChatAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
