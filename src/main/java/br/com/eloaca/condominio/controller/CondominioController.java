package br.com.eloaca.condominio.controller;

import br.com.eloaca.condominio.entity.Apartamento;
import br.com.eloaca.condominio.entity.Condominio;
import br.com.eloaca.condominio.service.CondominioService;
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

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/api/condominio/condominio")
@RequiredArgsConstructor
public class CondominioController {

    private final CondominioService service;

    @PostMapping("/novo")
    @ResponseStatus(HttpStatus.CREATED)
    public Condominio novo(@RequestBody Condominio condominio){
        return service.salvarCondominio(condominio);
    }

    @GetMapping("/buscarID/{id}")
    public Optional<Condominio> buscar(@PathVariable Long id){
        return service.buscarCondominio(id);
    }

    @DeleteMapping("/excluir/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable Long id){
        service.excluirCondominio(id);
    }

    @GetMapping("/buscarTodos")
    public List buscarTodos(){
        return service.buscarTodosCondominio();
    }

    @GetMapping("/buscarNome/{nome}")
    public Condominio buscarNome(@PathVariable String nome){
        return service.buscarCondominioPorNome(nome);
    }

    @PostMapping("/buscarCondominioApartamento/")
    @ResponseStatus(HttpStatus.FOUND)
    public Condominio buscarCondominioApartamento(@RequestBody Apartamento apartamento){
        return service.buscarCondominioPorApartamento(apartamento);
    }

}
