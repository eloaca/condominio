package br.com.eloaca.condominio.service;

import br.com.eloaca.condominio.entity.Apartamento;
import br.com.eloaca.condominio.entity.Documento;
import br.com.eloaca.condominio.entity.Visitante;
import br.com.eloaca.condominio.entity.TipoDocumento;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import static org.easymock.EasyMock.*;

public class VisitanteServiceTest {

    VisitanteService service;
    
    @BeforeMethod
    public void init() {
        service = createNiceMock(VisitanteService.class);    
    }

    @Test
    public void testSalvarVisitante() {
        var mock = criarVisitanteMock();
        expect(service.salvarVisitante(mock)).andReturn(mock);
        replay(service);
        var Visitante = service.salvarVisitante(mock);
        verify(service);
        Assert.assertEquals(Visitante, mock);
    }

    @Test
    public void testBuscarVisitante() {
        var mock = Optional.of(criarVisitanteMock());
        expect(service.buscarVisitante(1L)).andReturn(mock);
        replay(service);
        var Visitante = service.buscarVisitante(1L);
        verify(service);
        Assert.assertEquals(Visitante, mock);
    }

    @Test
    public void testExcluirVisitante() {
        var mock = criarVisitanteMock();
        service.excluirVisitante(mock.getId());
        expect(service.buscarVisitante(mock.getId())).andReturn(null);
        replay(service);
        var Visitante = service.buscarVisitante(1L);
        Assert.assertNull(Visitante);
    }

    @Test
    public void testBuscarTodosVisitantes() {
        var mock = criarVisitanteMock();
        var mocks = new ArrayList<Visitante>();
        mocks.add(mock);
        expect(service.buscarTodosVisitantes()).andReturn(mocks);
        replay(service);
        var visitantes = service.buscarTodosVisitantes();
        verify(service);
        Assert.assertEquals(visitantes, mocks);
    }

    @Test
    public void testBuscarVisitantePeloNome() {
        var mock = criarVisitanteMock();
        var mocks = new ArrayList<Visitante>();
        mocks.add(mock);
        expect(service.buscarVisitantePeloNome("Eloá")).andReturn(mocks);
        replay(service);
        var visitantes = service.buscarVisitantePeloNome("Eloá");
        verify(service);
        Assert.assertEquals(visitantes, mocks);
    }

    private Documento criarDocumentoMock() {
        return new Documento(1L, TipoDocumento.RG, "253369630");
    }

    private Apartamento criarApartamentoMock() {
        return new Apartamento(2L, "D", "112");
    }

    private Visitante criarVisitanteMock() {
        var documentosMock = new ArrayList<Documento>();
        documentosMock.add(criarDocumentoMock());
        var apartamentosMock = new ArrayList<Apartamento>();
        apartamentosMock.add(criarApartamentoMock());
        return new Visitante(3L, "Elida Augusto", LocalDateTime.now(), LocalDateTime.now(), documentosMock, apartamentosMock);
    }
}