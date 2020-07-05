package com.cwl.mail.controller;

import com.cwl.mail.service.ItemSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ItemSearchController {
    @Autowired
    ItemSearchService itemSearchService;

    @RequestMapping("/search")
    public Map search(@RequestBody Map searchMap){

        return itemSearchService.search(searchMap);
    }

    @RequestMapping("/searchElasticSearch")
    public Map searchElasticSearch(@RequestBody Map searchMap){

        return itemSearchService.searchElasticSearch(searchMap);
    }
}
