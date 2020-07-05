package com.cwl.mail.junit;

import com.cwl.mail.mapper.TbGoodsMapper;
import com.cwl.mail.pojo.TbGoods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestMapper {
    @Autowired
    TbGoodsMapper tbGoodsMapper;
    @Test
    public void testMapper(){
        List<TbGoods> tbGoods = tbGoodsMapper.selectByExample(null);
        System.out.println(tbGoods.get(0));
    }
}
