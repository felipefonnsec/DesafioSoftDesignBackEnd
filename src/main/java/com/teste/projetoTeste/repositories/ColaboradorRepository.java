package com.teste.projetoTeste.repositories;

import com.teste.projetoTeste.models.ColaboradorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository<ColaboradorModel, Long> {
    boolean existsByNome(String nome);
}
