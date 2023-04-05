package com.itvedant.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.itvedant.model.Address;
import com.itvedant.model.Library;

@Repository
public interface AddressRepository extends 
			PagingAndSortingRepository<Address, Integer> {
	
	@Cacheable(cacheNames = {"addresses"})
	Iterable<Address> findAll();
	
	@RestResource(path = "locationcontain")
	List<Address> findByLocationContaining(String string);
}
