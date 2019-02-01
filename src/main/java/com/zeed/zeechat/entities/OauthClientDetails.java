package com.zeed.zeechat.entities;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.*;

public class OauthClientDetails implements ClientDetails {

    private static final long serialVersionUID = -1000000000000L;

    @Id
    private String id;

    private String clientName;

    private String clientId;

    private String clientSecret;

    private String scope = "profile";

    private String resourceIds;    // comma separated list of accessible resource server ids

    private String authorizedGrantTypes = "implicit,client_credentials,password";

    private String webServerRedirectUris;

    private String autoApproveScopes;

    private String authorities;

    private Integer accessTokenValiditySeconds = 86400;    // 24 hour token validity

    private Integer refreshTokenValiditySeconds;

    private String additionalInformation;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public Set<String> getResourceIds() {
        return new HashSet<>(Arrays.asList(this.resourceIds.split(",")));
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    @Override
    public boolean isSecretRequired() {
        return this.clientSecret != null;
    }

    @Override
    public String getClientSecret() {
        return this.clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    @Override
    public boolean isScoped() {
        return this.scope != null && !this.scope.isEmpty();
    }

    @Override
    public Set<String> getScope() {
        return new HashSet<String>(Arrays.asList(this.scope.split(",")));
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return new HashSet<String>(Arrays.asList(this.authorizedGrantTypes.split(",")));
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return new HashSet<String>(Arrays.asList(this.webServerRedirectUris.split(",")));
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        String[] auths = this.authorities.split(",");
        List<SimpleGrantedAuthority> gAuths = new ArrayList<>();
        for (String authority : auths) {
            gAuths.add(new SimpleGrantedAuthority(authority));
        }
        return new ArrayList<>(gAuths);

    }

    public String getAuthorizedGrantTypesAsString() {
        return this.authorizedGrantTypes;
    }

    public String getResourceIdsAsString() {
        return this.resourceIds;
    }


    public String getAuthoritiesAsString() {
        return this.authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return this.accessTokenValiditySeconds;
    }

    public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return this.refreshTokenValiditySeconds;
    }

    public void setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {
        this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return false;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }


    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getWebServerRedirectUris() {
        return webServerRedirectUris;
    }

    public void setWebServerRedirectUris(String webServerRedirectUris) {
        this.webServerRedirectUris = webServerRedirectUris;
    }

    public String getAutoApproveScopes() {
        return autoApproveScopes;
    }

    public void setAutoApproveScopes(String autoApproveScopes) {
        this.autoApproveScopes = autoApproveScopes;
    }


    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getAdditionalInformationn(){
        return this.additionalInformation;
    }

    @Override
    public String toString() {
        return "OauthClientDetails{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", clientId='" + clientId + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", scope='" + scope + '\'' +
                ", resourceIds='" + resourceIds + '\'' +
                ", authorizedGrantTypes='" + authorizedGrantTypes + '\'' +
                ", webServerRedirectUris='" + webServerRedirectUris + '\'' +
                ", autoApproveScopes='" + autoApproveScopes + '\'' +
                ", authorities='" + authorities + '\'' +
                ", accessTokenValiditySeconds=" + accessTokenValiditySeconds +
                ", refreshTokenValiditySeconds=" + refreshTokenValiditySeconds +
                '}';
    }


    public String getScopeAsString() {
        return this.scope;
    }
}

