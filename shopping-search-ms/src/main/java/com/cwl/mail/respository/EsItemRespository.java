package com.cwl.mail.respository;

import com.cwl.mail.document.EsItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsItemRespository extends ElasticsearchRepository<EsItem,Long> {
    public Page<EsItem> findByTitleAndBrand(String title, String brand, Pageable pageable);
    /*
    {"multi_match": {"query": "小米","fields": ["title","batch","category"]}}
     */
    @Query("{\"multi_match\": {\"query\": \"?0\",\"fields\": [\"title\",\"batch\",\"category\"]}}")
    public Page<EsItem> findByKeyword(String keyword, Pageable pageable);
}
