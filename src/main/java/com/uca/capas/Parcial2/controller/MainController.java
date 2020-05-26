package com.uca.capas.Parcial2.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.Parcial2.domain.Categoria;
import com.uca.capas.Parcial2.domain.Libro;
import com.uca.capas.Parcial2.service.CategoriaServices;
import com.uca.capas.Parcial2.service.LibroServices;


@Controller
public class MainController {
	
	@Autowired
	private LibroServices libroService;
	
	@Autowired
	private CategoriaServices categoriaService;
	
	@RequestMapping("/index")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/ingresarCategoria")
	public ModelAndView ingresarCategoria(@ModelAttribute Categoria categoria, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("categoria");
		return mav;
	}
	
	@RequestMapping("/guardarCategoria")
	public ModelAndView guardarCategoria(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("categoria");
		} else {
			try {
				categoriaService.insert(categoria);
				String exito = "Categoria guardada con exito";
				mav.addObject("exito", exito);
				mav.setViewName("index");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return mav;
	}
	
	@RequestMapping("/ingresarLibro")
	public ModelAndView ingresarLibro(@ModelAttribute Libro libro, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		List<Categoria> categorias = null;
		try {
			categorias = categoriaService.findAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("categorias", categorias);
		mav.addObject("libro", new Libro());
		mav.setViewName("libro");
		return mav;
	}
	
	@RequestMapping("/guardarLibro")
	public ModelAndView guardarLibro(@Valid @ModelAttribute Libro libro, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			List<Categoria> categorias = null;
			try {
				categorias = categoriaService.findAll();
			} catch(Exception e) {
				e.printStackTrace();
			}
			mav.addObject("categorias", categorias);
			mav.setViewName("libro");
		} else {
			try {
				Date date  = new Date(System.currentTimeMillis());
				libro.setF_ingreso(date);
				libroService.insert(libro);
				String exito = "Libro guardado con exito";
				mav.addObject("exito", exito);
				mav.setViewName("index");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return mav;
	}
	
	@RequestMapping("/mostrarLibros")
	public ModelAndView mostrarLibros() {
		ModelAndView mav = new ModelAndView();
		List<Libro> libros = null;
		try {
			libros = libroService.findAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("libros", libros);
		mav.setViewName("verLibros");
		return mav;
	}
	
}
