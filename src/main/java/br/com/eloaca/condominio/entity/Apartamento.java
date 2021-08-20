package br.com.eloaca.condominio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "apartamento")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Apartamento implements Serializable {

    private static final long serialVersionUID = -6831091463889068292L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bloco;

    private String numero;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(unique = true)
    private Condominio condominio;
}
