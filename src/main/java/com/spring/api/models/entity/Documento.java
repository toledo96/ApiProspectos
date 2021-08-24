package com.spring.api.models.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

@Entity
public class Documento implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private String nombre;
	
	@NotNull
	private String tipo;
	
	@Lob
	private byte[] dato;
	
	@JsonBackReference
	@ManyToOne()
	@JoinColumn(name = "prospecto_id")
	private Prospecto prospecto;
	
	public Documento() {}
	

	public Documento(String nombre, String tipo, byte[] dato) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.dato = dato;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public byte[] getData() {
		return dato;
	}

	public void setData(byte[] dato) {
		this.dato = dato;
	}

	public Prospecto getProspecto() {
		return prospecto;
	}

	public void setProspecto(Prospecto prospecto) {
		this.prospecto = prospecto;
	}
	
	
	
}
