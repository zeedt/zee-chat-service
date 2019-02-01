package com.zeed.zeechat.security.oauth2;

import com.zeed.zeechat.entities.User;
import com.zeed.zeechat.repository.UserRepository;
import com.zeed.zeechat.security.entity.UserWrapper;
import com.zeed.zeechat.security.exception.ZeeChatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class OauthAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Qualifier("customPasswordEncoder")
    private PasswordEncoder customPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (authentication.getCredentials() !=null ) ? authentication.getCredentials().toString() : null;

        User user = userRepository.findTopByUsername(username);

        if (user == null) {
            throw new ZeeChatException("Customer not found");
        }

        if (!customPasswordEncoder.matches(password, user.getPassword())) {
            throw new ZeeChatException("Username/password incorrect");
        }

        UsernamePasswordAuthenticationToken tokenAuthentication = new UsernamePasswordAuthenticationToken(UserWrapper.builder().user(user).build(), password, new ArrayList<>());

        tokenAuthentication.setDetails(authentication.getDetails());

        return tokenAuthentication;
    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }
}
