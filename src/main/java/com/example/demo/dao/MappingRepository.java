package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Documents;
import com.example.demo.entities.Mapping;
@Repository
public interface MappingRepository extends JpaRepository<Mapping, Long> {
	@Query("select map from Mapping map where map= :x ")
	public Mapping chercherMap(@Param("x") int x );

}
