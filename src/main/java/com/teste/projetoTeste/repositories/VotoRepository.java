package com.teste.projetoTeste.repositories;

import com.teste.projetoTeste.models.ColaboradorModel;
import com.teste.projetoTeste.models.PautaModel;
import com.teste.projetoTeste.models.VotoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends JpaRepository<VotoModel, Long> {
    boolean existsByPautaAndColaborador(PautaModel pauta, ColaboradorModel colaborador);

    long countByPauta(PautaModel pauta);
}
