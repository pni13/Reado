package com.itvedant.model;

import org.springframework.beans.factory.annotation.Value;

public interface LibraryWithAddress {
	@Value("#{target.id}")
	Integer getLibraryId();
	@Value("#{target.name}")
	String getLibraryName();
	Address getAddress();
}
