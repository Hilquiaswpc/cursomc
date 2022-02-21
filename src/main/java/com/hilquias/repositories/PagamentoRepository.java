package com.hilquias.repositories;

import com.hilquias.domain.Cidade;
import com.hilquias.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

    Optional<Pagamento> findById(Integer id);

    @Override
    List<Pagamento> findAll();
}
