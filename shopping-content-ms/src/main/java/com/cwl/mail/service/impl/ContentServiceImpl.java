package com.cwl.mail.service.impl;

import com.cwl.mail.mapper.TbContentCategoryMapper;
import com.cwl.mail.mapper.TbContentMapper;

import com.cwl.mail.pojo.TbContent;
import com.cwl.mail.pojo.TbContentCategory;
import com.cwl.mail.pojo.TbContentExample;
import com.cwl.mail.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    TbContentMapper tbContentMapper;
    @Autowired
    TbContentCategoryMapper tbContentCategoryMapper;
    @Autowired
    RedisTemplate redisTemplate;
    @Override
    public List<TbContent> findAllContent() {
        return tbContentMapper.selectByExample(null);
    }

    @Override
    public List<TbContentCategory> findAllCategory() {
        return tbContentCategoryMapper.selectByExample(null);
    }

    @Override
    public void addContent(TbContent tbContent) {
        tbContentMapper.insert(tbContent);
        redisTemplate.boundHashOps("content").delete(tbContent.getCategoryId());
    }

    @Override
    public void updateContent(TbContent tbContent) {
        TbContent oldContent = tbContentMapper.selectByPrimaryKey(tbContent.getId());
        System.out.println("修改开始");
        System.out.println("old:"+oldContent);
        System.out.println("old"+oldContent.getCategoryId());
        redisTemplate.boundHashOps("content").delete(oldContent.getCategoryId());
        tbContentMapper.updateByPrimaryKey(tbContent);
        if(tbContent.getCategoryId()!=oldContent.getCategoryId()){
            redisTemplate.boundHashOps("content").delete(tbContent.getCategoryId());
        }
    }

    @Override
    public TbContent findContentById(long id) {
        return tbContentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteContents(long[] ids) {
        for (long id:ids) {
            TbContent tbContent = tbContentMapper.selectByPrimaryKey(id);
            redisTemplate.boundHashOps("content").delete(tbContent.getCategoryId());
            tbContentMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<TbContent> findByCatrgoryId(Long categoryId) {
        List<TbContent> list = (List<TbContent>)redisTemplate.boundHashOps("content").get(categoryId);

        if(list==null){
            System.out.println("======查询数据库========");
            TbContentExample example = new TbContentExample();
            TbContentExample.Criteria criteria = example.createCriteria();
            criteria.andStatusEqualTo("1");
            criteria.andCategoryIdEqualTo(categoryId);
            example.setOrderByClause("sort_order");
            list = tbContentMapper.selectByExample(example);
            redisTemplate.boundHashOps("content").put(categoryId,list);
        }else{
            System.out.println("=============从缓存中获取===========");
        }
        return list;
    }
}
