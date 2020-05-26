package com.uca.capas.Parcial2.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.Parcial2.domain.Categoria;
import com.uca.capas.Parcial2.domain.Libro;

public interface CategoriaDAO {
	
	public List<Categoria> findAll() throws DataAccessException;
	
	public void insert(Categoria categoria) throws DataAccessException;
	
}
