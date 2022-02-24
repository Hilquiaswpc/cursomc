package com.hilquias.repositories;

import com.hilquias.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer>  {

	Optional<ItemPedido> findById(Integer id);

	@Override
	List<ItemPedido> findAll();
}
