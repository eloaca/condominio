package br.com.eloaca.condominio.service;

import br.com.eloaca.condominio.entity.Documento;
import br.com.eloaca.condominio.entity.TipoDocumento;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.easymock.EasyMock.*;

public class DocumentoServiceTest {

    DocumentoService service;

    @BeforeMethod
    public void init() {
        service = createNiceMock(DocumentoService.class);
    }

    @Test
    public void testSalvarDocumento() {
        var mock = criarDocumentoMock();
        expect(service.salvarDocumento(mock)).andReturn(mock);
        replay(service);
        var documento = service.salvarDocumento(mock);
        verify(service);
        Assert.assertEquals(documento, mock);
    }

    @Test
    public void testBuscarDocumento() {
        var mock = Optional.of(criarDocumentoMock());
        expect(service.buscarDocumento(1L)).andReturn(mock);
        replay(service);
        var documento = service.buscarDocumento(1L);
        verify(service);
        Assert.assertNotNull(documento);
    }

    @Test
    public void testExcluirDocumento() {
        service.excluirDocumento(1L);
        expect(service.buscarDocumento(1L)).andReturn(null);
        replay(service);
        var documento = service.buscarDocumento(1L);
        Assert.assertNull(documento);
    }

    @Test
    public void testBuscarTodosDocumento() {
        var mock = criarDocumentoMock();
        var mocks = new ArrayList<Documento>();
        mocks.add(mock);
        expect(service.buscarTodosDocumento()).andReturn(mocks);
        replay(service);
        var docs = service.buscarTodosDocumento();
        verify(service);
        Assert.assertEquals(docs, mocks);
    }

    @Test
    public void testBuscarPeloNumero() {
        var mock = criarDocumentoMock();
        var mocks = new ArrayList<Documento>();
        mocks.add(mock);
        expect(service.buscarPeloNumero("253369630")).andReturn(mocks);
        replay(service);
        var docs = service.buscarPeloNumero("253369630");
        verify(service);
        Assert.assertEquals(docs, mocks);
    }

    private Documento criarDocumentoMock() {
        return new Documento(1L, TipoDocumento.RG, "253369630");
    }

}