package com.itvedant.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "book-author", types = {Author.class})
public interface BookAndAuthor {
	@Value("#{target.id}")
	Integer getAuthorId();
	@Value("#{target.name}")
	String getAuthorName();
	List<Book> getBook();
}
