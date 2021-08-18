package br.com.eloaca.condominio.service;

import antlr.collections.List;
import br.com.eloaca.condominio.entity.Visitante;
import br.com.eloaca.condominio.repository.VisitanteRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class VisitanteService {

    private final VisitanteRepository repository;

    public Visitante salvarVisitante(@NonNull Visitante Visitante){
        return repository.save(Visitante);
    }

    public Optional<Visitante> buscarVisitante(@NonNull Long id){
        return repository.findById(id);
    }

    public void excluirVisitante(@NonNull Long id){
        repository.deleteById(id);
    }

    public List buscarTodosVisitantes(){
        return (List) repository.findAll();
    }

    public List buscarVisitantePeloNome(@NonNull String nome){
        return repository.findByNomeLike(nome);
    }
}
