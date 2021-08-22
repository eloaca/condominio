package br.com.eloaca.condominio.repository;

import br.com.eloaca.condominio.entity.Apartamento;
import br.com.eloaca.condominio.entity.Condominio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.List;

public interface CondominioRepository extends JpaRepository<Condominio, Long> {

    @Query("select c from condominio c where c.apartamento = ?1")
    Condominio findByApartamento(@NonNull Apartamento apartamento);

    @Query("select c from condominio c where c.nome = ?1")
    Condominio findByNome(@NonNull String nome);
}
