package br.com.eloaca.condominio.repository;

import br.com.eloaca.condominio.entity.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {

    @Query("select d from documento d where d.numero = ?1")
    List<Documento> findByNumero(@Nullable String numero);
}
