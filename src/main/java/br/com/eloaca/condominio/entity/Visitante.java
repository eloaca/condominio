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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


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

    @OneToMany(cascade = CascadeType.ALL)
    private List<Documento> documento;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Apartamento> apartamento;
}
