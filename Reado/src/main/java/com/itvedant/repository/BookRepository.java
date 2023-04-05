package com.itvedant.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.itvedant.model.Book;
import com.itvedant.model.BooksWithLibrary;

@RepositoryRestResource(excerptProjection = BooksWithLibrary.class)
public interface BookRepository extends 
			PagingAndSortingRepository<Book, Integer> {
	
	@Cacheable(cacheNames = {"books"})
	Iterable<Book> findAll();
	
	@RestResource(path = "titlecontain")
	List<Book> findByTitleContaining(String string);
}
