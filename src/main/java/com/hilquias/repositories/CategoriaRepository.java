package com.hilquias.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hilquias.domain.Categoria;



@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>  {

	Optional<Categoria> findById(Integer id);

	@Override
	List<Categoria> findAll();
}
