package com.hilquias.repositories;


import com.hilquias.domain.itemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ItemPedidoRepository extends JpaRepository<itemPedido, Integer>  {

	Optional<itemPedido> findById(Integer id);

	@Override
	List<itemPedido> findAll();
}
