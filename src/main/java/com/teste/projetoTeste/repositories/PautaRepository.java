package com.teste.projetoTeste.repositories;

import com.teste.projetoTeste.models.PautaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PautaRepository extends JpaRepository<PautaModel, Long> {
}
