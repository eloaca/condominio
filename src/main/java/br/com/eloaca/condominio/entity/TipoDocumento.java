package br.com.eloaca.condominio.entity;

import java.util.List;
import java.util.Arrays;

public enum TipoDocumento {
    RG,
    CPF,
    Passaporte,
    CNH,
    CNPJ,
    CNE;

    public static List<TipoDocumento> getTipoDocumentos(){
        return Arrays.asList(values());
    }
}
