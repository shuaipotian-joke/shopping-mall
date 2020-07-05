package com.cwl.mail.service.impl;

import com.cwl.mail.mapper.TbSpecificationMapper;
import com.cwl.mail.mapper.TbSpecificationOptionMapper;
import com.cwl.mail.pojo.TbSpecification;
import com.cwl.mail.pojo.TbSpecificationOption;
import com.cwl.mail.pojo.TbSpecificationOptionExample;
import com.cwl.mail.pojogroup.Specification;
import com.cwl.mail.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SpecificationServiceImpl implements SpecificationService {
    @Autowired
    TbSpecificationMapper tbSpecificationMapper;
    @Autowired
    TbSpecificationOptionMapper tbSpecificationOptionMapper;
    @Override
    public List<TbSpecification> findAllSpecification() {
        return tbSpecificationMapper.selectByExample(null);
    }

    @Override
    public void addSpecification(Specification specification) {
        tbSpecificationMapper.insert(specification.getTbSpecification());
        List<TbSpecificationOption> specificationOptionList = specification.getSpecificationOptionList();
        for(TbSpecificationOption tbSpecificationOption:specificationOptionList){
            tbSpecificationOption.setSpecId(specification.getTbSpecification().getId());
            tbSpecificationOptionMapper.insert(tbSpecificationOption);
        }
    }

    @Override
    public Specification findOneSpecification(long id) {
        TbSpecification tbSpecification = tbSpecificationMapper.selectByPrimaryKey(id);
        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
        criteria.andSpecIdEqualTo(id);
        List<TbSpecificationOption> specificationOptionList = tbSpecificationOptionMapper.selectByExample(example);
        Specification specification = new Specification();
        specification.setTbSpecification(tbSpecification);
        specification.setSpecificationOptionList(specificationOptionList);
        return specification;
    }

    @Override
    public void updateSpecification(Specification specification) {
        tbSpecificationMapper.updateByPrimaryKey(specification.getTbSpecification());
        long spcId = specification.getTbSpecification().getId();
        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
        criteria.andSpecIdEqualTo(spcId);
        tbSpecificationOptionMapper.deleteByExample(example);
        List<TbSpecificationOption> specificationOptionList = specification.getSpecificationOptionList();
        for(TbSpecificationOption tbSpecificationOption:specificationOptionList){
            tbSpecificationOption.setSpecId(spcId);
            tbSpecificationOptionMapper.insert(tbSpecificationOption);
        }
    }

    @Override
    public void deleteSpecification(long[] ids) {
        for (long i : ids) {
            TbSpecificationOptionExample example = new TbSpecificationOptionExample();
            TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
            criteria.andSpecIdEqualTo(i);
            List<TbSpecificationOption> specificationOptionList = tbSpecificationOptionMapper.selectByExample(example);

             tbSpecificationOptionMapper.deleteByExample(example);

            tbSpecificationMapper.deleteByPrimaryKey(i);
        }
    }
}
