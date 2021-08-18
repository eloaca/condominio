package br.com.eloaca.condominio.repository;

import antlr.collections.List;
import br.com.eloaca.condominio.entity.Morador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface MoradorRepository extends JpaRepository<Morador, Long> {

    @Query("select m from morador m where m.nome like ?1")
    List findByNomeLike(@NonNull String nome);
}
