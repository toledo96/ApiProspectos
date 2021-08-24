package com.spring.api.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.spring.api.models.entity.Documento;
import com.spring.api.models.entity.Prospecto;
import com.spring.api.repositories.DocumentoRepository;
import com.spring.api.repositories.ProspectoRepository;

@Service
public class DocStorageService {
	
	private final Path root = Paths.get("uploads");
	
	@Autowired
	private DocumentoRepository fileRepository;
	
	@Autowired
	private ProspectoRepository prospectoRepository;
	
	public void init() {
		try {
			
			Files.createDirectory(root);
			System.out.println("Se creo la carpeta");
			
		} catch (IOException e) {
			throw new RuntimeException("No se puede iniciar el storage");
		}
		
	}
	
	public void save(MultipartFile[] files,Prospecto prospecto) {
	    try {
	    	prospectoRepository.save(prospecto);
	        Arrays.asList(files).stream().forEach(file -> {
	        	try {
					Documento documento = new Documento(file.getOriginalFilename(),file.getContentType(),file.getBytes());
					documento.setProspecto(prospecto);
					fileRepository.save(documento);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        });

	      } catch (Exception e) {
	        e.printStackTrace();
	      } 
	}
	
	
	public List<Documento> getFiles(Integer id){
		Prospecto prospecto = prospectoRepository.findById(id).orElse(null);
		return prospecto.getDocumentos();
	}
	
	
	public Prospecto editar(Integer id, Prospecto prospecto) {		
		Prospecto Prospecto_viejo = prospectoRepository.findById(id).orElse(null);
		Prospecto_viejo.setNombre(prospecto.getNombre());
		Prospecto_viejo.setApellidoPaterno(prospecto.getApellidoPaterno());
		Prospecto_viejo.setApellidoMaterno(prospecto.getNombre());
		Prospecto_viejo.setCalle(prospecto.getCalle());
		Prospecto_viejo.setNumeroCasa(prospecto.getNumeroCasa());
		Prospecto_viejo.setColonia(prospecto.getColonia());
		Prospecto_viejo.setCp(prospecto.getCp());
		Prospecto_viejo.setRfc(prospecto.getRfc());
		Prospecto_viejo.setEstatus(prospecto.getEstatus());
		Prospecto_viejo.setObservaciones(prospecto.getObservaciones());
		prospectoRepository.save(Prospecto_viejo);
		return Prospecto_viejo;
	}
	
	public List<Prospecto> Listado(){
		List<Prospecto> lista = (List<Prospecto>) prospectoRepository.findAll();
		return lista;
	}
	
}
