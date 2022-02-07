package com.hilquias.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hilquias.domain.Estado;



@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>  {

	Optional<Estado> findById(Integer id);

	@Override
	List<Estado> findAll();
}
