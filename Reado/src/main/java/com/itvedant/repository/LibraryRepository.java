package com.itvedant.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.itvedant.model.Library;
import com.itvedant.model.LibraryWithAddress;

@RepositoryRestResource(excerptProjection = LibraryWithAddress.class)
public interface LibraryRepository extends 
			PagingAndSortingRepository<Library, Integer> {
	
	@Cacheable
	Iterable<Library> findAll();
	
	@RestResource(path = "namecontain")
	List<Library> findByNameContaining(String string);
}
