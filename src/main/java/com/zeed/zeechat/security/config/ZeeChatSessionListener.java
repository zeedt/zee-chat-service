package com.zeed.zeechat.security.config;

import org.apache.catalina.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ZeeChatSessionListener implements HttpSessionListener {

    private Logger logger = LoggerFactory.getLogger(SessionListener.class.getName());

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        event.getSession().setMaxInactiveInterval(5*60);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        logger.info("Session has expired for user");
    }
}
