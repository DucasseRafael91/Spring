package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Article;

public interface ArticleRepository extends JpaRepository<Article,Long> {
  public Optional<Article> findById(Long id);
  public List<Article> findByBrand(String brand);
  public List<Article> findByDescription(String description);
  public List<Article> findByBrandContains(String brand);
  public List<Article> findByBrandAndPrice(String brand, double price);
  public void deleteById(Long id);

}
