package com.xat.management.rest.api;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/products")
public class ProductResource {

	@RequestMapping(method = RequestMethod.GET)
    String listProducts() {
		return "Product List";
    }
}
