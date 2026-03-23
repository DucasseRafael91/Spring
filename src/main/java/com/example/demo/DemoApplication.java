package com.example.demo;

import com.example.demo.dao.ArticleRepository;
import com.example.demo.dao.CategoryRepository;
import com.example.demo.entities.Article;
import com.example.demo.entities.Category;
import java.util.Optional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication(scanBasePackages = "com.example")
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ArticleRepository articleRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public void updateById(Long id) {
		Article article = articleRepository.findById(id).orElseThrow();
		article.setBrand("Honor");
		article.setDescription("Poco");
		articleRepository.save(article);
	}

	@Override
	public void run(String... args) throws Exception {
		updateById(2L);
	}
}