package br.com.eloaca.condominio.controller;

import java.util.List;
import br.com.eloaca.condominio.entity.Morador;
import br.com.eloaca.condominio.service.MoradorService;
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

import java.util.Optional;

@RestController
@RequestMapping("/api/condominio/morador")
@RequiredArgsConstructor
public class MoradorController {

    private final MoradorService service;

    @PostMapping("/novo")
    @ResponseStatus(HttpStatus.CREATED)
    public Morador novo(@RequestBody Morador morador){
        return service.salvarMorador(morador);
    }

    @GetMapping("/buscarID/{id}")
    public Optional<Morador> buscar(@PathVariable Long id){
        return service.buscarMorador(id);
    }

    @DeleteMapping("/excluir/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable Long id){
        service.excluirMorador(id);
    }

    @GetMapping("/buscarTodos")
    public List<Morador> buscarTodos(){
        return service.buscarTodosMoradores();
    }

    @GetMapping("/buscarNome/{nome}")
    public List<Morador> buscarNome(@PathVariable String nome){
        return service.buscarMoradoresPorNome(nome);
    }
}
