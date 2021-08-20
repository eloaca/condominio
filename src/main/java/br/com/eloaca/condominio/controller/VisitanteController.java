package br.com.eloaca.condominio.controller;

import br.com.eloaca.condominio.entity.Visitante;
import br.com.eloaca.condominio.service.VisitanteService;
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
@RequestMapping("/api/condominio/visitante")
@RequiredArgsConstructor
public class VisitanteController {

    private final VisitanteService service;

    @PostMapping("/novo")
    @ResponseStatus(HttpStatus.CREATED)
    public Visitante novo(@RequestBody Visitante Visitante){
        return service.salvarVisitante(Visitante);
    }

    @GetMapping("/buscarID/{id}")
    public Optional<Visitante> buscar(@PathVariable Long id){
        return service.buscarVisitante(id);
    }

    @DeleteMapping("/excluir/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable Long id){
        service.excluirVisitante(id);
    }

    @GetMapping("/buscarTodos")
    public List<Visitante> buscarTodos(){
        return service.buscarTodosVisitantes();
    }

    @GetMapping("/buscarNome/{nome}")
    public List<Visitante> buscarNome(@PathVariable String nome){
        return service.buscarVisitantePeloNome(nome);
    }
}
