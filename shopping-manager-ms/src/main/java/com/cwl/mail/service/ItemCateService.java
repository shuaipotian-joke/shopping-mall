package com.cwl.mail.service;

import com.cwl.mail.pojo.TbItemCat;

import java.util.List;

public interface ItemCateService {
    public List<TbItemCat> selectItemCat1List(long parentId);

    TbItemCat findOne(long id);

    List<TbItemCat> findItemCatList();
}
