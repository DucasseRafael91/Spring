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

	@Override
	public void run(String... args) throws Exception {
		for (Article article : articleRepository.findByBrand("Samsung")) {
			System.out.println(article);
		}
		System.out.println("Par description");
		for (Article article : articleRepository.findByDescription("S9")) {
			System.out.println(article);
		}
		articleRepository.deleteById(6L);
	}
}