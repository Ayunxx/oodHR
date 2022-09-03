package com.oodhr.admin.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"enabled","accountNonExpired", "accountNonLocked", "credentialsNonExpired", "authorities"})
public class HrVo implements UserDetails{

    private Integer id;

    private String username;

    private String password;

    private String phone;

    private String avatar;

    private Integer status;

    private String roleKey;

    private String roleName;

    private String remark;

    private List<String> roles;

    private List<SimpleGrantedAuthority> authorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authorities !=null) {
            return  authorities;
        }
        authorities = roles.stream().
                map(SimpleGrantedAuthority::new).
                collect(Collectors.toList());
        
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
