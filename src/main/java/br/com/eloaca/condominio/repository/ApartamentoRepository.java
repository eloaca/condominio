package br.com.eloaca.condominio.repository;

import br.com.eloaca.condominio.entity.Apartamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApartamentoRepository extends JpaRepository<Apartamento, Long> {

    @Query("select a from apartamento a where a.bloco = ?1 and a.numero = ?2")
    List<Apartamento> findByBlocoAndNumero(@NonNull String bloco, @NonNull String numero);
}
