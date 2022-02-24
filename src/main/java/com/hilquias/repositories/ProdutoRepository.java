package com.hilquias.repositories;

import com.hilquias.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>  {

	Optional<Produto> findById(Integer id);

	@Override
	List<Produto> findAll();
}
