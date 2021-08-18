package br.com.eloaca.condominio.service;

import java.time.LocalDateTime;
import java.util.List;
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

    public Visitante salvarVisitante(@NonNull Visitante visitante){
        visitante.setEntrada(LocalDateTime.now());
        visitante.setSaida(LocalDateTime.now());
        return repository.save(visitante);
    }

    public Optional<Visitante> buscarVisitante(@NonNull Long id){
        return repository.findById(id);
    }

    public void excluirVisitante(@NonNull Long id){
        repository.deleteById(id);
    }

    public List<Visitante> buscarTodosVisitantes(){
        return repository.findAll();
    }

    public List<Visitante> buscarVisitantePeloNome(@NonNull String nome){
        return repository.findByNomeLike(nome);
    }
}
