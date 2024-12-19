package com.ecom.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "product")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Product extends BaseEntity {

	@Column(length = 30)
	private String title;

	@Column(length = 100)
	private String description;

	private double price;

	private int quantity;

	private boolean status;

}
