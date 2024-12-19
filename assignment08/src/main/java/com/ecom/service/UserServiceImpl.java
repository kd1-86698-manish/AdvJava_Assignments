package com.ecom.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.dao.ProductDao;
import com.ecom.dao.UserDao;
import com.ecom.dto.ApiResponse;
import com.ecom.dto.UserReqDto;
import com.ecom.pojos.Product;
import com.ecom.pojos.User;
import com.ecom.pojos.UserRole;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addNewUser(UserReqDto userDto) {

		User userEntity = mapper.map(userDto, User.class);
		User persist = userDao.save(userEntity);

		return new ApiResponse("User Added with Id " + persist.getId());
	}

	@Override
	public List<Product> findByStatusTrue(Long userId) {

		User admin = userDao.findById(userId).orElseThrow(() -> new RuntimeException("Invalid UserId"));

		if (admin.getRole() == UserRole.CUSTOMER) {

			return productDao.findByStatusTrue();
		}
		return null;
	}

//	@Override
//	public List<Product> getAllProducts(Long ) {
//
//		User admin = userDao.findById(userId).orElseThrow(() -> new RuntimeException("Invalid UserId"));
//
//		if (admin.getRole() == UserRole.CUSTOMER ) {
//
//			return productDao.findAll();
//		}
//		return null;
//	}

}
