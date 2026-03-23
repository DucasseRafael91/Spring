package com.example.demo;

import com.example.demo.dao.ArticleRepository;
import com.example.demo.dao.CategoryRepository;
import com.example.demo.entities.Article;
import com.example.demo.entities.Category;
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
		Category smartphone = categoryRepository.save(new Category("Smartphone"));
		Category tablet = categoryRepository.save(new Category("Tablet"));
		Category pc = categoryRepository.save(new Category("PC"));

		articleRepository.save(new Article("Samsung","S10",500,smartphone));
		articleRepository.save(new Article("Samsung","S9",350,smartphone));
		articleRepository.save(new Article("Xiaomi","MI10",100,smartphone));

		articleRepository.save(new Article("Samsung","GalaxyTab",450,tablet));
		articleRepository.save(new Article("Apple","Ipad",350,tablet));

		articleRepository.save(new Article("Asus","R510",600,pc));
	}
}