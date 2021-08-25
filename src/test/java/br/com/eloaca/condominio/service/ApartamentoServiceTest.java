package br.com.eloaca.condominio.service;

import br.com.eloaca.condominio.entity.Apartamento;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.easymock.EasyMock.*;

public class ApartamentoServiceTest {

    private ApartamentoService service;

    @BeforeMethod
    public void init() {
        service = createNiceMock(ApartamentoService.class);
    }

    @Test
    public void testSalvarApartamento() {
        var mock = criarApartamentoMock();
        expect(service.salvarApartamento(mock)).andReturn(mock);
        replay(service);
        Apartamento apartamento = service.salvarApartamento(mock);
        verify(service);
        Assert.assertEquals(apartamento, mock);
    }

    @Test
    public void testBuscarApartamento() {
        var mocks = criarApartamentosMock();
        expect(service.buscarTodosApartamento()).andReturn(mocks);
        replay(service);
        var apartamentos = service.buscarTodosApartamento();
        verify(service);
        Assert.assertEquals(apartamentos, mocks);
    }

    @Test
    public void testExcluirApartamento() {
        Apartamento mock = criarApartamentoMock();
        service.excluirApartamento(mock.getId());
        expect(service.buscarApartamento(mock.getId())).andReturn(null);
        replay(service);
        Optional<Apartamento> apartamento = service.buscarApartamento(1L);
        Assert.assertNull(apartamento);
    }

    @Test
    public void testBuscarTodosApartamento() {
        var mocks = criarApartamentosMock();
        expect(service.buscarTodosApartamento()).andReturn(mocks);
        replay(service);
        var apartamentos = service.buscarTodosApartamento();
        verify(service);
        Assert.assertEquals(apartamentos, mocks);
    }

    @Test
    public void testBuscarPeloBlocoENumero() {
        var mocks = criarApartamentosMock();
        expect(service.buscarPeloBlocoENumero(anyString(), anyString())).andReturn(mocks);
        replay(service);
        var apartamentos = service.buscarPeloBlocoENumero("D", "112");
        verify(service);
        Assert.assertEquals(apartamentos, mocks);
    }

    private Apartamento criarApartamentoMock() {
        return new Apartamento(2L, "D", "112");
    }

    private List criarApartamentosMock() {
        List<Apartamento> apartamentosMock = new ArrayList<>();
        apartamentosMock.add(criarApartamentoMock());
        return apartamentosMock;
    }
}