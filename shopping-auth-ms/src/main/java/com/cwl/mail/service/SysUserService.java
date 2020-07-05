package com.cwl.mail.service;


import com.cwl.mail.pojo.TbSeller;

public interface SysUserService {
    public TbSeller findUserByUsercode(String usercode);
}
