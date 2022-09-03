package com.oodhr.admin.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.util.Assert;

import java.util.Collection;

/**
 * @auther Ayun
 * @date 2022/8/24 13:34
 */
public class JsonAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    private final Object principal; // 用户

    private Object credentials; // 密码

    // 其它方法可以完全一样
    /**
     * 此构造函数用来初始化未授信凭据.
     * @param principal
     * @param credentials
     */
    public JsonAuthenticationToken(Object principal, Object credentials) {
        super(null);
        this.principal = principal;
        this.credentials = credentials;
        setAuthenticated(false);
    }
    /**
     * 此构造函数用来初始化授信凭据.
     * @param authorities
     * @param principal
     * @param credentials
     */
    public JsonAuthenticationToken(Object principal, Object credentials,
                                   Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        super.setAuthenticated(true); // 必须使用父类的setAuthenticated，子类此方法已被重写
    }

    /**
     * 未授信凭据的静态工厂方法
     * @param principal
     * @param credentials
     * @return
     */
    public static JsonAuthenticationToken noAuthenticated(Object principal, Object credentials) {
        return new JsonAuthenticationToken(principal, credentials);
    }

    /**
     * 初始化授信凭据的静态工厂方法
     * @param principal
     * @param credentials
     * @param authorities
     * @return
     */
    public static JsonAuthenticationToken authenticated(Object principal, Object credentials,
                                                        Collection<? extends GrantedAuthority> authorities) {
        return new JsonAuthenticationToken(principal, credentials, authorities);
    }

    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        Assert.isTrue(!isAuthenticated,
                "不能设置为授信认证，请调用父类授信方法！");
        super.setAuthenticated(false);
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
        this.credentials = null;
    }
}
