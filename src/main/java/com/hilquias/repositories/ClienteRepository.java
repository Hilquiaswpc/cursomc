package com.hilquias.repositories;

import com.hilquias.domain.Cliente;
import com.hilquias.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>  {

	Optional<Cliente> findById(Integer id);

	@Transactional(readOnly = true)
	Cliente findByEmail(String email);

	@Transactional(readOnly = true)
    Cliente findByNome(String nome);

	@Override
	List<Cliente> findAll();


}
