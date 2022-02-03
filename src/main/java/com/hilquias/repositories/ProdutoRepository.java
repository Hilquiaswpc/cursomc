package com.hilquias.repositories;

import com.hilquias.domain.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProdutoRepository extends JpaRepository<Produtos, Integer>  {

	Optional<Produtos> findById(Integer id);

	@Override
	List<Produtos> findAll();
}
