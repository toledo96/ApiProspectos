package com.spring.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.spring.api.models.entity.Documento;

public interface DocumentoRepository extends CrudRepository<Documento, Integer>{

}
