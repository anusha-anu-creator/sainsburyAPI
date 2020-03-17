
package com.sainsbury;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.sainsbury.controller.ProductController;
import com.sainsbury.entity.Product;
import com.sainsbury.service.IProducts;

@SpringBootTest
@AutoConfigureMockMvc
class AnuSainsburyappApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ProductController controller;
	

	@MockBean
	private IProducts iProducts;

	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
	
	@Test
	public void shouldReturnDummyProductsFromService() throws Exception {
		List<Product> dummyProducts = new ArrayList<>();
		Product product = new Product();
		product.setTitle("xyz");
		product.setDescription("xyz");
		product.setKcal(10);
		product.setUnit_price(10.5);
		
		dummyProducts.add(product);
		
		when(iProducts.getAllProducts()).thenReturn(dummyProducts);
		
		this.mockMvc.perform(get("/getproducts")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("xyz")));
	}
	
	


	
	
}
