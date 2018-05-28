package com.example.demo.dao;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Documents;

@Repository
public interface DocumentsRepository extends JpaRepository<Documents, Long> {
	public List<Documents> findById(int ident);
	public Page<Documents> findById(int n, Pageable pageable);
	@Query("select doc from Documents doc where doc.type like :x ")
	public Documents chercherDoc(@Param("x") String type );
	
}
