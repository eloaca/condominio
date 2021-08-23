package br.com.eloaca.condominio.controller;

import br.com.eloaca.condominio.entity.Apartamento;
import br.com.eloaca.condominio.service.ApartamentoService;
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
@RequestMapping("/api/condominio/apartamento")
@RequiredArgsConstructor
public class ApartamentoController {

    private final ApartamentoService service;

    @PostMapping("/novo")
    @ResponseStatus(HttpStatus.CREATED)
    public Apartamento novo(@RequestBody Apartamento apartamento){
        return service.salvarApartamento(apartamento);
    }

    @GetMapping("/buscarID/{id}")
    public Optional<Apartamento> buscar(@PathVariable Long id){
        return service.buscarApartamento(id);
    }

    @DeleteMapping("/excluir/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable Long id){
        service.excluirApartamento(id);
    }

    @GetMapping("/buscarTodos")
    public List buscarTodos(){
        return service.buscarTodosApartamento();
    }

    @GetMapping("/buscarBlocoNumero/{bloco}/{numero}")
    public List buscarNumero(@PathVariable String bloco, @PathVariable String numero){
        return service.buscarPeloBlocoENumero(bloco, numero);
    }

}
