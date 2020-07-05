package com.cwl.mail.service.impl;

import com.cwl.mail.controller.ItemCatController;
import com.cwl.mail.mapper.TbItemCatMapper;
import com.cwl.mail.pojo.TbItemCat;
import com.cwl.mail.pojo.TbItemCatExample;
import com.cwl.mail.service.ItemCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemCateServiceImpl implements ItemCateService {
    @Autowired
    TbItemCatMapper tbItemCatMapper;
    @Override
    public List<TbItemCat> selectItemCat1List(long parentId) {
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        return tbItemCatMapper.selectByExample(example);
    }

    @Override
    public TbItemCat findOne(long id) {

        return tbItemCatMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TbItemCat> findItemCatList() {
        System.out.println("##########");
        return tbItemCatMapper.selectByExample(null);
    }
}
