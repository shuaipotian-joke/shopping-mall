package com.cwl.mail.service;

import java.util.List;
import java.util.Map;

public interface ItemSearchService {
    Map search(Map searchMap);

    void importList(List list);

    Map searchElasticSearch(Map searchMap);
}
