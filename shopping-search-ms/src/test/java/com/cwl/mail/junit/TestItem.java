package com.cwl.mail.junit;

import com.cwl.mail.document.EsItem;
import com.cwl.mail.pojo.TbItem;
import com.cwl.mail.respository.EsItemRespository;
import com.cwl.mail.service.ItemSearchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class TestItem {
    @Autowired
    SolrTemplate solrTemplate;
    @Autowired
    EsItemRespository esItemRespository;
    @Autowired
    ItemSearchService itemSearchService;
    @Test
    public void search() {
        Map searchMap = new HashMap();
        searchMap.put("keywords","苹果");
        Map map = new HashMap();
        Query query = new SimpleQuery("*:*");
        Criteria criteria = new Criteria("item_keywords").is(searchMap.get("keywords"));
        query.addCriteria(criteria);
        ScoredPage<TbItem> page = solrTemplate.queryForPage("collection1", query, TbItem.class);
        map.put("rows",page.getContent());
        System.out.println(map);
    }
    @Test
    public void searchElasticSearch() {
        Map searchMap = new HashMap();
        searchMap.put("keywords","小米");
        Map map = itemSearchService.searchElasticSearch(searchMap);
        System.out.println(map);
    }

}
