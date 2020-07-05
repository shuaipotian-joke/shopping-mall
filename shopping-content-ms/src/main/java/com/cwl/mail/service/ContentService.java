package com.cwl.mail.service;

import com.cwl.mail.pojo.TbContent;
import com.cwl.mail.pojo.TbContentCategory;

import java.util.List;

public interface ContentService {
    public List<TbContent> findAllContent();

    public List<TbContentCategory> findAllCategory();

    public void addContent(TbContent tbContent);

    public void updateContent(TbContent tbContent);

    public TbContent findContentById(long id);

    public void deleteContents(long[] ids);

    public List<TbContent> findByCatrgoryId(Long categoryId);
}
