package com.spring.api.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

@Entity
public class Prospecto implements Serializable{

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
	private String apellidoPaterno;
	
	@NotNull
	private String apellidoMaterno;
	
	@NotNull
	private String calle;
	
	@NotNull
	private String numeroCasa;
	
	@NotNull
	private String colonia;
	
	@NotNull
	private String cp;
	
	@NotNull
	private String tel;
	
	@NotNull
	private String rfc;
	
	@NotNull
	private String estatus;
	
	@Nullable
	private String Observaciones;
	


	@JsonManagedReference
	@OneToMany(mappedBy = "prospecto",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Documento> documentos;
	
	public Prospecto() {}

	public Prospecto(String nombre, String apellidoPaterno, String apellidoMaterno, String calle, String numeroCasa,
			String colonia, String cp, String tel, String rfc, String estatus) {
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.calle = calle;
		this.numeroCasa = numeroCasa;
		this.colonia = colonia;
		this.cp = cp;
		this.tel = tel;
		this.rfc = rfc;
		this.estatus = estatus;
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

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void addDocumento(Documento documento) {
		this.documentos.add(documento);
	}
	
	public String getObservaciones() {
		return Observaciones;
	}

	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}
	
}
