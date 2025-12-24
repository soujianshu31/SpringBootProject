package com.test.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.Tenant;
import com.test.service.TenantService;

@RestController
@RequestMapping("/tenant")
public class TenantController {

	@Autowired
	private TenantService service;
	
	@PostMapping("/register")
	public Tenant register(@RequestBody Tenant tenant) {
		return service.registerTenant(tenant);
	}
}
