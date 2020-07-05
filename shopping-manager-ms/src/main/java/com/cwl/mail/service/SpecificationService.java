package com.cwl.mail.service;

import com.cwl.mail.pojo.TbSpecification;
import com.cwl.mail.pojogroup.Specification;

import java.util.List;

public interface SpecificationService {
    public List<TbSpecification> findAllSpecification();

    public void addSpecification(Specification specification);

    public Specification findOneSpecification(long id);

    public void updateSpecification(Specification specification);

    public void deleteSpecification(long[] ids);
}
