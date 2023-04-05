package com.itvedant.model;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String title;
	
	@ManyToOne
	@JoinColumn(name = "library_id")
	private Library library;
	
	@ManyToMany
	@JoinTable(name = "book_author",
	           joinColumns = @JoinColumn(name = "book_id"),
	           inverseJoinColumns = @JoinColumn(name = "author_id"))
	private List<Author> authors;
	
	@CreatedDate
	private Instant createdDate;
	@LastModifiedDate
	private Instant modifiedDate;
}
