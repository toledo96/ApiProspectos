package com.spring.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.spring.api.models.entity.Prospecto;

public interface ProspectoRepository extends CrudRepository<Prospecto, Integer>{
//	@Query(value = "Select d from Documento d left join d.id p where d.prospecto=?1 ")
//	public Prospecto findWithDocument(Integer id);
	
}
