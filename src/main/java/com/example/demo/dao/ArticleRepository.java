package com.example.demo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Article;

public interface ArticleRepository extends JpaRepository<Article,Long> {
  public List<Article> findByBrand(String brand);
  public List<Article> findByBrandContains(String brand);
  public List<Article> findByBrandAndPrice(String brand, double price);

}
