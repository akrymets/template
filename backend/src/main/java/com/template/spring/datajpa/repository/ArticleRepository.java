package com.template.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.template.spring.datajpa.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	List<Article> findByPublished(boolean published);

	List<Article> findByTitleContaining(String title);
}
