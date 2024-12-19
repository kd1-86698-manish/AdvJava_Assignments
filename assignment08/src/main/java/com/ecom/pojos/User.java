package com.ecom.pojos;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true, exclude = { "orders" })

public class User extends BaseEntity {

	@Column(length = 30)
	private String name;

	@Column(length = 30, unique = true)
	private String email;

	@Column(length = 30, nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private UserRole role;

	@OneToMany(mappedBy = "userId")
	List<Orders> orders = new ArrayList<>();

}
