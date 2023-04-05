package com.itvedant.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.itvedant.model.Author;

@Repository
public interface AuthorRepository extends 
			PagingAndSortingRepository<Author, Integer> {
	
	@Cacheable(cacheNames = {"authors"})
	Iterable<Author> findAll();
	
	@RestResource(path = "namecontain")
	List<Author> findByNameContaining(String string);
}
