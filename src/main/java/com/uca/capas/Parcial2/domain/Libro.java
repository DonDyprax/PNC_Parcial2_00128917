package com.uca.capas.Parcial2.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(schema="public", name="cat_libro")
public class Libro {
	
	@Id
	@Column(name="c_libro")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer c_libro;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="c_categoria")
	private Categoria categoria;
	
	@Transient
	private Integer c_categoria;
	
	@Column(name="s_titulo")
	@Size(max=500, message="El titulo no puede tener mas de 500 caracteres.")
	@NotEmpty(message="Este campo no puede ir vacio.")
	private String s_titulo;
	
	@Column(name="s_autor")
	@Size(max=150, message="El autor no puede tener mas de 150 caracteres.")
	@NotEmpty(message="Este campo no puede ir vacio.")
	private String s_autor;
	
	@Column(name="b_estado")
	private Boolean b_estado;
	
	@Column(name="f_ingreso")
	private Date f_ingreso;
	
	@Column(name="s_isbn")
	@NotEmpty(message="Este campo no puede ir vacio.")
	private String s_isbn;
	
	public Libro() {

	}

	public String getS_isbn() {
		return s_isbn;
	}

	public void setS_isbn(String s_isbn) {
		this.s_isbn = s_isbn;
	}



	public Integer getC_libro() {
		return c_libro;
	}

	public void setC_libro(Integer c_libro) {
		this.c_libro = c_libro;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getC_categoria() {
		return c_categoria;
	}

	public void setC_categoria(Integer c_categoria) {
		this.c_categoria = c_categoria;
	}

	public String getS_titulo() {
		return s_titulo;
	}

	public void setS_titulo(String s_titulo) {
		this.s_titulo = s_titulo;
	}

	public String getS_autor() {
		return s_autor;
	}

	public void setS_autor(String s_autor) {
		this.s_autor = s_autor;
	}

	public Boolean getB_estado() {
		return b_estado;
	}

	public void setB_estado(Boolean b_estado) {
		this.b_estado = b_estado;
	}
	
	
	public Date getF_ingreso() {
		return f_ingreso;
	}
	
	public void setF_ingreso(Date f_ingreso) {
		this.f_ingreso = f_ingreso;
	}
	
	public String getF_ingresoDelegate() {
		if(this.f_ingreso == null) {
			return "";
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh.mm aa");
			return sdf.format(getF_ingreso());
		}
		
	}

}
