package com.spring.api.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.api.models.entity.Documento;
import com.spring.api.models.entity.Prospecto;
import com.spring.api.repositories.DocumentoRepository;
import com.spring.api.repositories.ProspectoRepository;
import com.spring.api.service.DocStorageService;
import com.spring.api.service.IProspectosService;

@RestController
@CrossOrigin("*")
public class AdminController {
	
	@Autowired
	private ProspectoRepository prospectoRepository;
	
	@Autowired
	private IProspectosService service;

	@PostMapping("/agregar")
	public boolean  guardar(Prospecto prospecto, @RequestParam("files") MultipartFile[] files){
	    try {
	    	service.save(files, prospecto);
	        return  true;
	      } catch (Exception e) {
	        return false;
	      } 	
		
	}
	
	@GetMapping("/listado")
	public List<Prospecto> Listado(){
		List<Prospecto> lista = service.Listado();
		return lista;
	}
	
	@GetMapping("/prospecto/{id}")
	public Prospecto encontrado(@PathVariable Integer id) {
		return service.BuscarPorId(id);
	}
	
	@PutMapping("/prospecto/editar/{id}")
	public Prospecto editar(@PathVariable Integer id, Prospecto prospecto) {		
		Prospecto Prospecto_viejo = service.editar(id, prospecto);
		return Prospecto_viejo;
	}
	
	@GetMapping("/download/{id}")
	public List<Documento> descargarArchivos(@PathVariable Integer id){
		List<Documento> documentos = service.getFiles(id);
		return documentos;
	}
	
	
	
	
	
	
	

}
