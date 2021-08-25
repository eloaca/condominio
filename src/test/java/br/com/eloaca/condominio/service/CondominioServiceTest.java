package br.com.eloaca.condominio.service;

import br.com.eloaca.condominio.entity.Apartamento;
import br.com.eloaca.condominio.entity.Condominio;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

public class CondominioServiceTest {

    CondominioService service;

    @BeforeMethod
    public void init() {
        service = createNiceMock(CondominioService.class);
    }

    @Test
    public void testSalvarCondominio() {
        var mock = criarCondominioMock();
        expect(service.salvarCondominio(mock)).andReturn(mock);
        replay(service);
        var condominio = service.salvarCondominio(mock);
        verify(service);
        Assert.assertEquals(condominio, mock);
    }

    @Test
    public void testBuscarCondominio() {
        var mock = Optional.of(criarCondominioMock());
        expect(service.buscarCondominio(1L)).andReturn(mock);
        replay(service);
        var condominio = service.buscarCondominio(1L);
        verify(service);
        Assert.assertEquals(condominio, mock);
    }

    @Test
    public void testExcluirCondominio() {
        var mock = criarCondominioMock();
        service.excluirCondominio(mock.getId());
        expect(service.buscarCondominio(mock.getId())).andReturn(null);
        replay(service);
        var morador = service.buscarCondominio(1L);
        Assert.assertNull(morador);
    }

    @Test
    public void testBuscarTodosCondominio() {
        var mocks = criarCondominiosMock();
        expect(service.buscarTodosCondominio()).andReturn(mocks);
        replay(service);
        var condominios = service.buscarTodosCondominio();
        verify(service);
        Assert.assertEquals(condominios, mocks);
    }

    @Test
    public void testBuscarCondominioPorApartamento() {
        var mock = criarCondominioMock();
        expect(service.buscarCondominioPorApartamento(criarApartamentoMock())).andReturn(mock);
        replay(service);
        var condominio = service.buscarCondominioPorApartamento(criarApartamentoMock());
        verify(service);
        Assert.assertEquals(condominio, mock);
    }

    private Apartamento criarApartamentoMock() {
        return new Apartamento(2L, "D", "112");
    }

    private Condominio criarCondominioMock() {
        var apartamentosMock = new ArrayList<Apartamento>();
        apartamentosMock.add(criarApartamentoMock());
        return new Condominio(4L, "Vila Souza Campos", apartamentosMock);
    }

    private List criarCondominiosMock() {
        var mocks = new ArrayList<Condominio>();
        mocks.add(criarCondominioMock());
        return mocks;
    }
}