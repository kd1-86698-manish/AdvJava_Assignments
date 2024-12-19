package com.ecom.dto;

import com.ecom.pojos.UserRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserReqDto {

	private String name;

	private String email;

	private String password;

	private UserRole role;
}
