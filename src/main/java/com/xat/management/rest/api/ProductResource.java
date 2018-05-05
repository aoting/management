package com.xat.management.rest.api;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xat.model.Product;
import com.xat.services.ProductService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/products")
public class ProductResource {
	
	@Autowired
	ProductService productService;

	@RequestMapping(method = RequestMethod.GET)
    List<Product> listProducts() {
		return productService.getProducts();
    }
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/search")
    List<Product> searchProducts(@RequestParam("name") String name) {
		return productService.searchByName(name);
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public void saveOrganisation(@RequestBody Product product) {
		if (product.getId() != null && !StringUtils.isEmpty(product.getId())) {
			productService.save(product);
		} else {
			productService.create(product);
		}
	}
}
