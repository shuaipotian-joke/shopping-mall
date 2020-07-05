package com.cwl.mail.service;

import com.cwl.mail.pojo.TbTypeTemplate;

import java.util.List;
import java.util.Map;

public interface TemplateService {
    public List<Map> findSpecList(Long id);

    public List<TbTypeTemplate> findAllTemplate();

    public List<Map> findSpecList();

    public List<Map> findBrandList();

    public TbTypeTemplate findOne(long id);

    public void updateTemplate(TbTypeTemplate tbTypeTemplate);

    public void addTemplate(TbTypeTemplate tbTypeTemplate);

    public void deleteTemplate(long[] ids);
}
