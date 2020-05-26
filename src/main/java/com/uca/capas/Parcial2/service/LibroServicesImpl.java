package com.uca.capas.Parcial2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.Parcial2.dao.LibroDAO;
import com.uca.capas.Parcial2.domain.Libro;

@Service
public class LibroServicesImpl implements LibroServices {

	@Autowired
	private LibroDAO libroDAO;
	
	@Override
	public List<Libro> findAll() throws DataAccessException {
		return libroDAO.findAll();
	}

	@Override
	public void insert(Libro libro) throws DataAccessException {
		libroDAO.insert(libro);
	}

}