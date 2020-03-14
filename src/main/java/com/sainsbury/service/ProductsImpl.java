package com.sainsbury.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sainsbury.entity.Product;
import com.sainsbury.repo.ProductRepo;

@Service
public class ProductsImpl implements IProducts {

	@Autowired
	ProductRepo pr;

	@Override
	public List<Product> getAllProducts() {
		return pr.findAll();
	}

}
