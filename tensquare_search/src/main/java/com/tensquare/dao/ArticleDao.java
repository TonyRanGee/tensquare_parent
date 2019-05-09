package com.tensquare.dao;

import com.tensquare.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

public interface ArticleDao extends ElasticsearchCrudRepository<Article,String> {

    public Page<Article> findByTitleOrContentLike(String title, String  content, Pageable pageable);
}
