package br.com.eloaca.condominio.service;

import br.com.eloaca.condominio.entity.Apartamento;
import br.com.eloaca.condominio.entity.Documento;
import br.com.eloaca.condominio.entity.Visitante;
import br.com.eloaca.condominio.entity.TipoDocumento;
import br.com.eloaca.condominio.entity.Visitante;
import br.com.eloaca.condominio.entity.Visitante;
import org.easymock.EasyMock;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
        Visitante mock = criarVisitanteMock();
        expect(service.salvarVisitante(mock)).andReturn(mock);
        replay(service);
        Visitante Visitante = service.salvarVisitante(mock);
        verify(service);
        Assert.assertEquals(Visitante, mock);
    }

    @Test
    public void testBuscarVisitante() {
        Optional<Visitante> mock = Optional.of(criarVisitanteMock());
        expect(service.buscarVisitante(1L)).andReturn(mock);
        replay(service);
        Optional<Visitante> Visitante = service.buscarVisitante(1L);
        verify(service);
        Assert.assertEquals(Visitante, mock);
    }

    @Test
    public void testExcluirVisitante() {
        Visitante mock = criarVisitanteMock();
        service.excluirVisitante(mock.getId());
        expect(service.buscarVisitante(mock.getId())).andReturn(null);
        replay(service);
        Optional<Visitante> Visitante = service.buscarVisitante(1L);
        Assert.assertNull(Visitante);
    }

    @Test
    public void testBuscarTodosVisitantes() {
        Visitante mock = criarVisitanteMock();
        List<Visitante> mocks = new ArrayList<>();
        mocks.add(mock);
        expect(service.buscarTodosVisitantes()).andReturn(mocks);
        replay(service);
        List<Visitante> Visitantees = service.buscarTodosVisitantes();
        verify(service);
        Assert.assertEquals(Visitantees, mocks);
    }

    @Test
    public void testBuscarVisitantePeloNome() {
        Visitante mock = criarVisitanteMock();
        List<Visitante> mocks = new ArrayList<>();
        mocks.add(mock);
        expect(service.buscarVisitantePeloNome("Eloá")).andReturn(mocks);
        replay(service);
        List<Visitante> Visitantees = service.buscarVisitantePeloNome("Eloá");
        verify(service);
        Assert.assertEquals(Visitantees, mocks);
    }

    private Documento criarDocumentoMock() {
        return new Documento(1L, TipoDocumento.RG, "253369630");
    }

    private Apartamento criarApartamentoMock() {
        return new Apartamento(2L, "D", "112");
    }

    private Visitante criarVisitanteMock() {
        List<Documento> documentosMock = new ArrayList<>();
        documentosMock.add(criarDocumentoMock());
        List<Apartamento> apartamentosMock = new ArrayList<>();
        apartamentosMock.add(criarApartamentoMock());
        return new Visitante(3L, "Elida Augusto", LocalDateTime.now(), LocalDateTime.now(), documentosMock, apartamentosMock);
    }
}