package com.cwl.mail.service.impl;

import com.alibaba.fastjson.JSON;
import com.cwl.mail.mapper.TbBrandMapper;
import com.cwl.mail.mapper.TbSpecificationMapper;
import com.cwl.mail.mapper.TbSpecificationOptionMapper;
import com.cwl.mail.mapper.TbTypeTemplateMapper;
import com.cwl.mail.pojo.TbSpecification;
import com.cwl.mail.pojo.TbSpecificationOption;
import com.cwl.mail.pojo.TbSpecificationOptionExample;
import com.cwl.mail.pojo.TbTypeTemplate;
import com.cwl.mail.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TemplateServiceImpl implements TemplateService {
    @Autowired
    TbTypeTemplateMapper tbTypeTemplateMapper;
    @Autowired
    TbSpecificationMapper tbSpecificationMapper;
    @Autowired
    TbTypeTemplateMapper typeTemplateMapper;
    @Autowired
    TbBrandMapper tbBrandMapper;
    @Autowired
    TbSpecificationOptionMapper specificationOptionMapper;
    @Override
    public List<Map> findSpecList(Long id) {
        //根据ID查询到模板对象
        TbTypeTemplate typeTemplate = typeTemplateMapper.selectByPrimaryKey(id);
        // 获得规格的数据spec_ids
        String specIds = typeTemplate.getSpecIds();// [{"id":27,"text":"网络"},{"id":32,"text":"机身内存"}]
        // 将specIds的字符串转成JSON的List<Map>
        List<Map> list = JSON.parseArray(specIds, Map.class);
        // 获得每条记录:
        for (Map map : list) {
            // 根据规格的ID 查询规格选项的数据:
            // 设置查询条件:
            TbSpecificationOptionExample example = new TbSpecificationOptionExample();
            TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
            criteria.andSpecIdEqualTo(new Long((Integer)map.get("id")));

            List<TbSpecificationOption> specOptionList = specificationOptionMapper.selectByExample(example);
            //查询tb_specification_oprion表，加载option_name字段，然后封装到map中
            map.put("options", specOptionList);//{"id":27,"text":"网络",options:[{id：xxx,optionName:移动2G}]}
        }
        return list;
    }

    @Override
    public List<TbTypeTemplate> findAllTemplate() {
        return tbTypeTemplateMapper.selectByExample(null);
    }

    @Override
    public List<Map> findSpecList() {
        return tbSpecificationMapper.selectOptionList();
    }

    @Override
    public List<Map> findBrandList() {
        return tbBrandMapper.selectOptionList();
    }

    @Override
    public TbTypeTemplate findOne(long id) {
        return tbTypeTemplateMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateTemplate(TbTypeTemplate tbTypeTemplate) {
        tbTypeTemplateMapper.updateByPrimaryKey(tbTypeTemplate);
    }

    @Override
    public void addTemplate(TbTypeTemplate tbTypeTemplate) {
        tbTypeTemplateMapper.insert(tbTypeTemplate);
    }

    @Override
    public void deleteTemplate(long[] ids) {
        for(long id:ids)
        tbTypeTemplateMapper.deleteByPrimaryKey(id);
    }
}
