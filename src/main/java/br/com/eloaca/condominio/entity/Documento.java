package br.com.eloaca.condominio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity(name = "documento")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Documento implements Serializable {

    private static final long serialVersionUID = 429760195278141490L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

    private String numero;

    @ManyToOne(cascade = CascadeType.ALL)
    private Morador morador;

    @ManyToOne(cascade = CascadeType.ALL)
    private Visitante visitante;
}
