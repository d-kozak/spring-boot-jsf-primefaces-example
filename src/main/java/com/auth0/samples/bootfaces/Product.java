package com.auth0.samples.bootfaces;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String name;

	@Column
	private BigDecimal price;

	public Product(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}
}
