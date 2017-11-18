package com.auth0.samples.bootfaces.service;

import com.auth0.samples.bootfaces.Product;
import com.auth0.samples.bootfaces.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Component
public class TaskReader {

	private final ProductRepository productRepository;

	@Autowired
	public TaskReader(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}


	@Scheduled(fixedRate = 2000)
	public void readRandomTask() {
		System.out.println("...Reading random task...");

		RestTemplate restTemplate = new RestTemplate();
		// I
		ResponseEntity<List<Task>> exchange = restTemplate.exchange("https://jsonplaceholder.typicode.com/todos", HttpMethod.GET, null, new ParameterizedTypeReference<List<Task>>() {
		});
		List<Task> tasks = exchange.getBody();
		Random random = new Random();
		Task randomTask = tasks.get(random.nextInt(tasks.size()));
		System.out.println("Randomly selected task " + randomTask);
		int randomValue = random.nextInt(1000);
		System.out.println("Randomly selected value " + randomValue);

		productRepository.save(new Product(randomTask.getTitle(), new BigDecimal(randomValue)));
		System.out.println(randomTask.getTitle() + " saved");
	}
}
