package br.com.eloaca.condominio.service;

import java.util.List;
import br.com.eloaca.condominio.entity.Morador;
import br.com.eloaca.condominio.repository.MoradorRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class MoradorService {

    private final MoradorRepository repository;

    public Morador salvarMorador(@NonNull Morador morador){
        return repository.save(morador);
    }

    public Optional<Morador> buscarMorador(@NonNull Long id){
        return repository.findById(id);
    }

    public void excluirMorador(@NonNull Long id){
        repository.deleteById(id);
    }

    public List<Morador> buscarTodosMoradores(){
        return repository.findAll();
    }

    public List<Morador> buscarMoradoresPorNome(@NonNull String nome){
        return repository.findByNomeLike(nome);
    }
}
