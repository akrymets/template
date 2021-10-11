package com.template.spring.datajpa.repository;

import java.util.List;

import com.template.spring.datajpa.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	List<Article> findByPublished(boolean published);
	List<Article> findByTitleContaining(String title);
}
