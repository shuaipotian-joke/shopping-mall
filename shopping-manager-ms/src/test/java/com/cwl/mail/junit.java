package com.cwl.mail;

import com.cwl.mail.mapper.TbBrandMapper;
import com.cwl.mail.mapper.TbGoodsMapper;
import com.cwl.mail.mapper.TbSpecificationOptionMapper;
import com.cwl.mail.pojo.*;
import com.cwl.mail.pojogroup.Specification;
import com.cwl.mail.service.GoodsService;
import com.cwl.mail.service.SpecificationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class junit {
    @Autowired
    TbBrandMapper tbBrandMapper;
    @Autowired
    TbSpecificationOptionMapper tbSpecificationOptionMapper;
    @Autowired
    SpecificationService specificationService;
    @Autowired
    TbGoodsMapper tbGoodsMapper;
    @Autowired
    GoodsService goodsService;
    @Test
    public void testBrandMapper(){
        List<TbBrand> brands = tbBrandMapper.selectByExample(null);
        System.out.println(brands.get(0).getFirstChar());
    }
    @Test
    public void testSpecification(){
        Specification specification = new Specification();
        TbSpecification tbSpecification = new TbSpecification();

        tbSpecification.setSpecName("容量");
        TbSpecificationOption tbSpecificationOption = new TbSpecificationOption();
        tbSpecificationOption.setSpecId(1L);
        tbSpecificationOption.setOptionName("1L");
        tbSpecificationOption.setOrders(1);
        List<TbSpecificationOption> list = new ArrayList();
        list.add(tbSpecificationOption);
        specification.setTbSpecification(tbSpecification);
        specification.setSpecificationOptionList(list);
        specificationService.addSpecification(specification);
    }
    @Test
    public void testDelete(){
        long[] ids = {40,41,42};
        for (long i:ids) {
            TbSpecificationOptionExample example = new TbSpecificationOptionExample();
            TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
            criteria.andSpecIdEqualTo(i);
            tbSpecificationOptionMapper.deleteByExample(example);
        }
    }
    @Test
    public void testUpdateStatus(){
        Long id = 149187842867912L;
        tbGoodsMapper.updateStatusByPrimaryKey(id);
    }

    @Test
    public void testFindItemListByGoodsIdListAndStatus(){
        Long[] ids = {149187842867955L,149187842867960L};
        List<TbItem> list = goodsService.findItemListByGoodsIdListAndStatus(ids, "1");
        System.out.println(list);
    }
}
