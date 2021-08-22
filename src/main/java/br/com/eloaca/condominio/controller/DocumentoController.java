package br.com.eloaca.condominio.controller;

import br.com.eloaca.condominio.entity.Documento;
import br.com.eloaca.condominio.service.DocumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/condominio/documento")
@RequiredArgsConstructor
public class DocumentoController {

    private final DocumentoService service;

    @PostMapping("/novo")
    @ResponseStatus(HttpStatus.CREATED)
    public Documento novo(@RequestBody Documento Documento){
        return service.salvarDocumento(Documento);
    }

    @GetMapping("/buscarID/{id}")
    public Optional<Documento> buscar(@PathVariable Long id){
        return service.buscarDocumento(id);
    }

    @DeleteMapping("/excluir/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable Long id){
        service.excluirDocumento(id);
    }

    @GetMapping("/buscarTodos")
    public List buscarTodos(){
        return service.buscarTodosDocumento();
    }

    @GetMapping("/buscarNumero/{numero}")
    public List<Documento> buscarNumero(@PathVariable String numero){
        return service.buscarPeloNumero(numero);
    }

}
