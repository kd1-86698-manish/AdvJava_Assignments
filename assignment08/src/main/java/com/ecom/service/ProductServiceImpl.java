package com.ecom.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.dao.ProductDao;
import com.ecom.dao.UserDao;
import com.ecom.dto.ApiResponse;
import com.ecom.dto.ProductDto;
import com.ecom.pojos.Product;
import com.ecom.pojos.User;
import com.ecom.pojos.UserRole;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addProduct(ProductDto dto) {

		User admin = userDao.findById(dto.getAdminId()).orElseThrow(() -> new RuntimeException("Invalid Admin Id"));

		if (admin.getRole() == UserRole.ADMIN) {

			Product entity = mapper.map(dto, Product.class);

			entity.setStatus(true);

			productDao.save(entity);

			return new ApiResponse("Product added");
		}

		return new ApiResponse("You must login as Admin");
	}

	@Override
	public ApiResponse deleteProduct(Long productId, Long userId) {

		User admin = userDao.findById(userId).orElseThrow(() -> new RuntimeException("Invalid UserId"));

		Product product = productDao.findById(productId)
				.orElseThrow(() -> new RuntimeException("Invalid Product Id..!"));

		if (admin.getRole() == UserRole.ADMIN && productDao.existsById(productId)) {
			product.setStatus(false);
			return new ApiResponse("Product Deleted Succesfully");
		}

		return new ApiResponse("Product Failed To delete");
	}

}
