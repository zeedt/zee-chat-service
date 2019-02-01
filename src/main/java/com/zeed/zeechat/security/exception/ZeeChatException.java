package com.zeed.zeechat.security.exception;

import org.springframework.security.core.AuthenticationException;

public class ZeeChatException extends AuthenticationException {


    public ZeeChatException(String message) {
        super(message);
    }

    public ZeeChatException(String message, Throwable cause) {
        super(message, cause);
    }
}
