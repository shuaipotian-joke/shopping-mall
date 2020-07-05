package com.cwl.mail.utils;


import com.cwl.mail.pojo.TbSeller;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

// 建议该类不放到pojo包中。
public class UserDetailImpl implements UserDetails {

    private TbSeller tbSeller;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailImpl(TbSeller tbSeller, Collection<? extends GrantedAuthority> authorities) {
        this.tbSeller = tbSeller;
        this.authorities = authorities;
    }

    @Override   //获取权限列表
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub    Bad Creditential
        return tbSeller.getPassword();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return tbSeller.getSellerId();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

    public TbSeller gettbSeller() {
        return tbSeller;
    }

    public void settbSeller(TbSeller tbSeller) {
        this.tbSeller = tbSeller;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

}
