package com.uca.capas.Parcial2.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.Parcial2.domain.Categoria;

public interface CategoriaServices {
	
	public List<Categoria>findAll() throws DataAccessException;
	
	public void insert(Categoria categoria) throws DataAccessException;

}
