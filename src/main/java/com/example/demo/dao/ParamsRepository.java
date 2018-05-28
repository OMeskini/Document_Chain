package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Mapping;
import com.example.demo.entities.Params;
@Repository
public interface ParamsRepository extends JpaRepository<Params, Integer> {
	@Query("select parameters from Params parameters where parameters.id_params= :x ")
	public Params chercherParams(@Param("x") int x );
}
