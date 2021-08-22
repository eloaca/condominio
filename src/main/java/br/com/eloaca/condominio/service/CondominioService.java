package br.com.eloaca.condominio.service;


import br.com.eloaca.condominio.entity.Apartamento;
import br.com.eloaca.condominio.entity.Condominio;
import br.com.eloaca.condominio.repository.CondominioRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class CondominioService {

    private final CondominioRepository repository;

    public Condominio salvarCondominio(@NonNull Condominio condominio){
        return repository.save(condominio);
    }

    public Optional<Condominio> buscarCondominio(@NonNull Long id){
        return repository.findById(id);
    }

    public void excluirCondominio(@NonNull Long id){
        repository.deleteById(id);
    }

    public List<Condominio> buscarTodosCondominio(){
        return repository.findAll();
    }

    public Condominio buscarCondominioPorApartamento(@NonNull Apartamento apartamento){
        return repository.findByApartamento(apartamento);
    }

    public Condominio buscarCondominioPorNome(@NonNull String nome){
        return repository.findByNome(nome);
    }
}
