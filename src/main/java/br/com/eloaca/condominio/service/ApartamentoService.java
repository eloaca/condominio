package br.com.eloaca.condominio.service;

import br.com.eloaca.condominio.entity.Apartamento;
import br.com.eloaca.condominio.repository.ApartamentoRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.List;

@Component
@AllArgsConstructor
public class ApartamentoService {

    private final ApartamentoRepository repository;

    public Apartamento salvarApartamento(@NonNull Apartamento apartamento){
        return repository.save(apartamento);
    }

    public Optional<Apartamento> buscarApartamento(@NonNull Long id){
        return repository.findById(id);
    }

    public void excluirApartamento(@NonNull Long id){
        repository.deleteById(id);
    }

    public List buscarTodosApartamento(){
        return repository.findAll();
    }

    public List buscarPeloBlocoENumero(@NonNull String bloco, @NonNull String numero){
        return repository.findByBlocoAndNumero(bloco, numero);
    }
}
