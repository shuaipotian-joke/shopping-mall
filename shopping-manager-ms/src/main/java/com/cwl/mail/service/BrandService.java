package com.cwl.mail.service;

import com.cwl.mail.pojo.TbBrand;

import java.util.List;

public interface BrandService {
    public List<TbBrand> findAllBrand();

    public void addBrand(TbBrand tbBrand);

    public void updateBreand(TbBrand tbBrand);

    public TbBrand findBrandById(long id);

    public void deleteBreands(long[] ids);
}
