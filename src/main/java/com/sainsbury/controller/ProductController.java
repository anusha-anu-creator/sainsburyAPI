package com.sainsbury.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sainsbury.entity.Product;
import com.sainsbury.service.IProducts;

@RestController
public class ProductController {
	@Autowired
	IProducts iProducts;
	
	@RequestMapping("/getproducts")
	public Map<String,Object> getallProducts() {
		List<Product> allProducts = iProducts.getAllProducts();
		System.out.println("allProducts"+allProducts);
		double grass=0;
		for(Product p :allProducts) {
			grass+=p.getUnit_price();
			System.out.println(p.getUnit_price()+":===:"+grass);
		}
		double vat  = (grass/100)*20;
		Map<String,Object> map = new HashMap<>();
		map.put("results",allProducts);
		Map<String,Object> total_map = new HashMap<>();
		total_map.put("grass", grass);
		total_map.put("vat", vat);
		map.put("total",total_map );
		return map;
	}
}
