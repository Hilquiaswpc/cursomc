package com.hilquias.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.hilquias.domain.Cidade;



@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>  {

	Optional<Cidade> findById(Integer id);

	@Override
	List<Cidade> findAll();
}
