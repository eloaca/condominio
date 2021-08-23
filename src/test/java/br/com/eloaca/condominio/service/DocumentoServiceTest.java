package br.com.eloaca.condominio.service;

import br.com.eloaca.condominio.entity.Documento;
import br.com.eloaca.condominio.entity.TipoDocumento;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
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
        Documento mock = criarDocumentoMock();
        expect(service.salvarDocumento(mock)).andReturn(mock);
        replay(service);
        Documento documento = service.salvarDocumento(mock);
        verify(service);
        Assert.assertEquals(documento, mock);
    }

    @Test
    public void testBuscarDocumento() {
        Optional<Documento> mock = Optional.of(criarDocumentoMock());
        expect(service.buscarDocumento(1L)).andReturn(mock);
        replay(service);
        Optional<Documento> documento = service.buscarDocumento(1L);
        verify(service);
        Assert.assertNotNull(documento);
    }

    @Test
    public void testExcluirDocumento() {
        service.excluirDocumento(1L);
        expect(service.buscarDocumento(1L)).andReturn(null);
        replay(service);
        Optional<Documento> documento = service.buscarDocumento(1L);
        Assert.assertNull(documento);
    }

    @Test
    public void testBuscarTodosDocumento() {
        Documento mock = criarDocumentoMock();
        List<Documento> mocks = new ArrayList<>();
        mocks.add(mock);
        expect(service.buscarTodosDocumento()).andReturn(mocks);
        replay(service);
        List<Documento> docs = service.buscarTodosDocumento();
        verify(service);
        Assert.assertEquals(docs, mocks);
    }

    @Test
    public void testBuscarPeloNumero() {
        Documento mock = criarDocumentoMock();
        List<Documento> mocks = new ArrayList<>();
        mocks.add(mock);
        expect(service.buscarPeloNumero("253369630")).andReturn(mocks);
        replay(service);
        List<Documento> docs = service.buscarPeloNumero("253369630");
        verify(service);
        Assert.assertEquals(docs, mocks);
    }

    private Documento criarDocumentoMock() {
        return new Documento(1L, TipoDocumento.RG, "253369630");
    }

}