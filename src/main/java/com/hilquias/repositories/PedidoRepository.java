package com.hilquias.repositories;

import com.hilquias.domain.Cidade;
import com.hilquias.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    Optional<Pedido> findById(Integer id);

    @Override
    List<Pedido> findAll();
}
