package br.com.eloaca.condominio.repository;

import br.com.eloaca.condominio.entity.Visitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitanteRepository extends JpaRepository<Visitante, Long> {

    @Query("select v from visitante v where v.nome like %?1%")
    List<Visitante> findByNomeLike(@NonNull String nome);
}
