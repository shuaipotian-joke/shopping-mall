package com.cwl.mail.service.impl;


import com.cwl.mail.mapper.TbSellerMapper;
import com.cwl.mail.pojo.TbSeller;
import com.cwl.mail.pojo.TbSellerExample;
import com.cwl.mail.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    TbSellerMapper tbSellerMapper;

    @Override
    public TbSeller findUserByUsercode(String usercode) {
        System.out.println("账号："+usercode);
        TbSellerExample example = new TbSellerExample();
        TbSellerExample.Criteria criteria = example.createCriteria();
        criteria.andSellerIdEqualTo(usercode);
        List<TbSeller> list = tbSellerMapper.selectByExample(example);
        if(list!=null&&list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
