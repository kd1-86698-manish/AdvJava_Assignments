package com.ecom.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderReqDTO extends BaseDTO {

	private Long productId;

	private Long userId;;

}
