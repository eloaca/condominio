package br.com.eloaca.condominio.service;

import br.com.eloaca.condominio.entity.Apartamento;
import br.com.eloaca.condominio.entity.Documento;
import br.com.eloaca.condominio.entity.Morador;
import br.com.eloaca.condominio.entity.TipoDocumento;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.easymock.EasyMock.*;

public class MoradorServiceTest {

    MoradorService service;

    @BeforeMethod
    public void init(){
        service = createNiceMock(MoradorService.class);
    }

    @Test
    public void testSalvarMorador() {
        var mock = criarMoradorMock();
        expect(service.salvarMorador(mock)).andReturn(mock);
        replay(service);
        var morador = service.salvarMorador(mock);
        verify(service);
        Assert.assertEquals(morador, mock);
    }

    @Test
    public void testBuscarMorador() {
        var mock = Optional.of(criarMoradorMock());
        expect(service.buscarMorador(1L)).andReturn(mock);
        replay(service);
        var morador = service.buscarMorador(1L);
        verify(service);
        Assert.assertEquals(morador, mock);
    }

    @Test
    public void testExcluirMorador() {
        var mock = criarMoradorMock();
        service.excluirMorador(mock.getId());
        expect(service.buscarMorador(mock.getId())).andReturn(null);
        replay(service);
        var morador = service.buscarMorador(1L);
        Assert.assertNull(morador);
    }

    @Test
    public void testBuscarTodosMoradores() {
        var mock = criarMoradorMock();
        var mocks = new ArrayList<Morador>();
        mocks.add(mock);
        expect(service.buscarTodosMoradores()).andReturn(mocks);
        replay(service);
        var moradores = service.buscarTodosMoradores();
        verify(service);
        Assert.assertEquals(moradores, mocks);
    }

    @Test
    public void testBuscarMoradoresPorNome() {
        var mock = criarMoradorMock();
        var mocks = new ArrayList<Morador>();
        mocks.add(mock);
        expect(service.buscarMoradoresPorNome("Eloá")).andReturn(mocks);
        replay(service);
        var moradores = service.buscarMoradoresPorNome("Eloá");
        verify(service);
        Assert.assertEquals(moradores, mocks);
    }

    private Documento criarDocumentoMock() {
        return new Documento(1L, TipoDocumento.RG, "253369630");
    }

    private Apartamento criarApartamentoMock() {
        return new Apartamento(2L, "D", "112");
    }

    private Morador criarMoradorMock() {
        var documentosMock = new ArrayList<Documento>();
        documentosMock.add(criarDocumentoMock());
        return new Morador(3L, "Eloá Augusto", documentosMock, criarApartamentoMock());
    }
}