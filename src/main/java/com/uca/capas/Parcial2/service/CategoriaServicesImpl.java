package com.uca.capas.Parcial2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.Parcial2.dao.CategoriaDAO;
import com.uca.capas.Parcial2.domain.Categoria;
import com.uca.capas.Parcial2.domain.Libro;

@Service
public class CategoriaServicesImpl implements CategoriaServices{
	
	@Autowired
	CategoriaDAO categoriaDao;

	@Override
	public List<Categoria> findAll() throws DataAccessException {
		return categoriaDao.findAll();
	}
	
	@Override
	public void insert(Categoria categoria) throws DataAccessException {
		categoriaDao.insert(categoria);
	}

}