package br.com.eloaca.condominio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity(name = "visitante")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Visitante implements Serializable {

    private static final long serialVersionUID = 1410097744521802167L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private LocalDateTime entrada;

    private LocalDateTime saida;

    @ManyToOne(cascade = CascadeType.ALL)
    private Documento documento;
}
