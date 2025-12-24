package com.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.Tenant;
import com.test.repository.TenantRepository;
import com.test.service.TenantService;

@Service
public class TenantServiceImpl implements TenantService {
    
	@Autowired
	private TenantRepository repo;
	@Override
	public Tenant registerTenant(Tenant tenant) {
	if(tenant.getAge()<18) {
		throw new RuntimeException("Tenant must atleast 18 years old");
	}
		return repo.save(tenant);
	}

}
