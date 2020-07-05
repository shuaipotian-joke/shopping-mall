package com.cwl.mail.service.impl;

import com.cwl.mail.mapper.TbBrandMapper;
import com.cwl.mail.pojo.TbBrand;
import com.cwl.mail.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    TbBrandMapper tbBrandMapper;
    @Override
    public List<TbBrand> findAllBrand() {
        return tbBrandMapper.selectByExample(null);
    }

    @Override
    public void addBrand(TbBrand tbBrand) {
        tbBrandMapper.insert(tbBrand);
    }

    @Override
    public void updateBreand(TbBrand tbBrand) {
        tbBrandMapper.updateByPrimaryKey(tbBrand);
    }

    @Override
    public TbBrand findBrandById(long id) {
        return tbBrandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteBreands(long[] ids) {
        for (long id:ids)
            tbBrandMapper.deleteByPrimaryKey(id);
    }
}
