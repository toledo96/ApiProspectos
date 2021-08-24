package com.spring.api.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.spring.api.models.entity.Documento;
import com.spring.api.models.entity.Prospecto;

public interface IProspectosService {
	
	public void save(MultipartFile[] files,Prospecto prospecto);
	public List<Documento> getFiles(Integer id);
	public Prospecto editar(Integer id, Prospecto prospecto);
	public Prospecto BuscarPorId(Integer id);
	public List<Prospecto> Listado();

}
