package com.cwl.mail.service.impl;

import com.cwl.mail.document.EsItem;
import com.cwl.mail.pojo.TbItem;
import com.cwl.mail.respository.EsItemRespository;
import com.cwl.mail.service.ItemSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemSearchServiceImpl implements ItemSearchService {
    @Autowired
    SolrTemplate solrTemplate;
    @Autowired
    EsItemRespository esItemRespository;
    @Override
    public Map search(Map searchMap) {
        Map map = new HashMap();
        System.out.println(searchMap);
        Query query = new SimpleQuery("*:*");
        Criteria criteria = new Criteria("item_keywords").is(searchMap.get("keywords"));
        query.addCriteria(criteria);
        ScoredPage<TbItem> page = solrTemplate.queryForPage("collection1", query, TbItem.class);
        map.put("rows",page.getContent());
        return map;
    }

    @Override
    public void importList(List list) {
        solrTemplate.saveBeans("collection1",list);
        solrTemplate.commit("collection1");
    }

    @Override
    public Map searchElasticSearch(Map searchMap) {
        Map map = new HashMap();
        System.out.println((String)searchMap.get("keywords"));

        Page<EsItem> page = esItemRespository.findByKeyword((String)searchMap.get("keywords"),null);
        map.put("rows",page.getContent());
        return map;
    }
}
