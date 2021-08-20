package br.com.eloaca.condominio.entity;

import java.io.Serializable;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "morador")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Morador implements Serializable  {

    private static final long serialVersionUID = 1050677815179965623L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Documento> documento;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(unique = true)
    private Apartamento apartamento;
}
