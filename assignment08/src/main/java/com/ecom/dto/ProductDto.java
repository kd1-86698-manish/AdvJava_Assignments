package com.ecom.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDto {

	private String title;

	private String description;

	private double price;

	private int quantity;

	private Long adminId;

}
