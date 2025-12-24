package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.model.Tenant;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long>{

}
