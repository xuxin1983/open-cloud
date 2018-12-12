package com.github.lyd.common.security;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Collections;

/**
 * @author liuyadu
 */
public class OpenAuth implements UserDetails {
    private static final long serialVersionUID = -123308657146774881L;
    private String accountType;
    private Long userId;
    private String username;
    private String password;
    private String nickName;
    private Collection<String> roles;
    private boolean accountNonLocked;
    private boolean accountNonExpired;
    private boolean enabled;
    private boolean credentialsNonExpired;
    private String authAppId;

    public OpenAuth() {
    }

    public OpenAuth(String accountType, Long userId, String username, String nickName, String password, Collection<String> authorities, boolean accountNonLocked, boolean accountNonExpired, boolean enabled, boolean credentialsNonExpired) {
        this.accountType = accountType;
        this.userId = userId;
        this.username = username;
        this.nickName = nickName;
        this.password = password;
        this.roles = authorities;
        this.accountNonLocked = accountNonLocked;
        this.accountNonExpired = accountNonExpired;
        this.enabled = enabled;
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (roles == null) {
            return Collections.EMPTY_LIST;
        }
        return AuthorityUtils.commaSeparatedStringToAuthorityList(StringUtils
                .collectionToCommaDelimitedString(roles));
    }

    @JsonIgnore
    @JSONField(serialize = false)
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<String> getRoles() {
        return roles;
    }

    public void setRoles(Collection<String> roles) {
        this.roles = roles;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAuthAppId() {
        return authAppId;
    }

    public void setAuthAppId(String authAppId) {
        this.authAppId = authAppId;
    }
}