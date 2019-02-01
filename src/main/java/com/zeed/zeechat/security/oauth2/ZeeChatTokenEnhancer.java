package com.zeed.zeechat.security.oauth2;

import com.zeed.zeechat.entities.User;
import com.zeed.zeechat.security.entity.UserWrapper;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class ZeeChatTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        if (!oAuth2Authentication.isClientOnly()) {
            UserWrapper userWrapper = (UserWrapper) oAuth2Authentication.getPrincipal();
            User user = userWrapper.getUser();
            Map<String,Object> additionalInfo = new HashMap<>();
            additionalInfo.put("username",user.getUsername());
            additionalInfo.put("firstName",user.getFirstName());
            additionalInfo.put("lastName",user.getLastName());
            additionalInfo.put("email",user.getEmail());

            ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInfo);
        }

        return oAuth2AccessToken;
    }
}
