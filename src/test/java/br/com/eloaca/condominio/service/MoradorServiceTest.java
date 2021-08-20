package br.com.eloaca.condominio.service;

import br.com.eloaca.condominio.entity.Apartamento;
import br.com.eloaca.condominio.entity.Condominio;
import br.com.eloaca.condominio.entity.Documento;
import br.com.eloaca.condominio.entity.Morador;
import br.com.eloaca.condominio.entity.TipoDocumento;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
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
        Morador mock = criarMoradorMock();
        expect(service.salvarMorador(mock)).andReturn(mock);
        replay(service);
        Morador morador = service.salvarMorador(mock);
        verify(service);
        Assert.assertEquals(morador, mock);
    }

    @Test
    public void testBuscarMorador() {
        Optional<Morador> mock = Optional.of(criarMoradorMock());
        expect(service.buscarMorador(1L)).andReturn(mock);
        replay(service);
        Optional<Morador> morador = service.buscarMorador(1L);
        verify(service);
        Assert.assertEquals(morador, mock);
    }

    @Test
    public void testExcluirMorador() {
        Morador mock = criarMoradorMock();
        service.excluirMorador(mock.getId());
        expect(service.buscarMorador(mock.getId())).andReturn(null);
        replay(service);
        Optional<Morador> morador = service.buscarMorador(1L);
        Assert.assertNull(morador);
    }

    @Test
    public void testBuscarTodosMoradores() {
        Morador mock = criarMoradorMock();
        List<Morador> mocks = new ArrayList<>();
        mocks.add(mock);
        expect(service.buscarTodosMoradores()).andReturn(mocks);
        replay(service);
        List<Morador> moradores = service.buscarTodosMoradores();
        verify(service);
        Assert.assertEquals(moradores, mocks);
    }

    @Test
    public void testBuscarMoradoresPorNome() {
        Morador mock = criarMoradorMock();
        List<Morador> mocks = new ArrayList<>();
        mocks.add(mock);
        expect(service.buscarMoradoresPorNome("Eloá")).andReturn(mocks);
        replay(service);
        List<Morador> moradores = service.buscarMoradoresPorNome("Eloá");
        verify(service);
        Assert.assertEquals(moradores, mocks);
    }

    private Documento criarDocumentoMock() {
        return new Documento(1L, TipoDocumento.RG, "253369630");
    }

    private Apartamento criarApartamentoMock() {
        return new Apartamento(2L, "D", "112", criarCondominioMock());
    }

    private Morador criarMoradorMock() {
        List<Documento> documentosMock = new ArrayList<>();
        documentosMock.add(criarDocumentoMock());
        return new Morador(3L, "Eloá Augusto", documentosMock, criarApartamentoMock());
    }

    private Condominio criarCondominioMock() {
        return new Condominio(4L, "Vila Souza Campos");
    }
}