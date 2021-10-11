package com.template.spring.datajpa.controller;

import com.template.spring.datajpa.model.Article;
import com.template.spring.datajpa.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "${appName.allowedApi}")
@RestController
@RequestMapping("/api")
public class ArticleController {
  @Autowired
  ArticleRepository articleRepository;

  @GetMapping("/articles")
  public List<Article> getAllArticles(@RequestParam(required = false) String title) {
    if (title == null) {
      return articleRepository.findAll();
    } else {
      return articleRepository.findByTitleContaining(title);
    }
  }

  @GetMapping("/articles/{id}")
  public Article getArticleById(@PathVariable("id") long id) {
    return articleRepository.getOne(id);
  }

  @PostMapping("/articles")
  public Article createArticle(@RequestBody Article article) {
    return articleRepository.save(article);
  }

  @PutMapping("/articles/{id}")
  public Article updateArticle(@PathVariable("id") long id, @RequestBody Article update) {
    Article article = articleRepository.getOne(id);
    article.setTitle(update.getTitle());
    article.setDescription(update.getDescription());
    article.setPublished(update.isPublished());
    return articleRepository.save(article);
  }

  @DeleteMapping("/articles/{id}")
  public ResponseEntity<HttpStatus> deleteArticle(@PathVariable("id") long id) {
    articleRepository.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/articles/published")
  public List<Article> findByPublished() {
    return articleRepository.findByPublished(true);
  }
}
