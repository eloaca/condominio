package br.com.eloaca.condominio.service;

import br.com.eloaca.condominio.entity.Documento;
import br.com.eloaca.condominio.repository.DocumentoRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
@AllArgsConstructor
public class DocumentoService {

    private final DocumentoRepository repository;

    public Documento salvarDocumento(@NonNull Documento documento){
        return repository.save(documento);
    }

    public Optional<Documento> buscarDocumento(@NonNull Long id){
        return repository.findById(id);
    }

    public void excluirDocumento(@NonNull Long id){
        repository.deleteById(id);
    }

    public List buscarTodosDocumento(){
        return (List) repository.findAll();
    }

    public List<Documento> buscarPeloNumero(@NonNull String numero){
        return repository.findByNumero(numero);
    }
}
