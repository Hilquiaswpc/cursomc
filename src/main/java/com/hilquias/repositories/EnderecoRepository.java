package com.hilquias.repositories;

import com.hilquias.domain.Cliente;
import com.hilquias.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>  {

	Optional<Endereco> findById(Integer id);

	@Override
	List<Endereco> findAll();
}
