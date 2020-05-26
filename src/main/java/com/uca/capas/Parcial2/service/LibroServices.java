package com.uca.capas.Parcial2.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.Parcial2.domain.Libro;

public interface LibroServices {
	
	public List<Libro> findAll() throws DataAccessException;
	
	public void insert(Libro libro) throws DataAccessException;
	
}
