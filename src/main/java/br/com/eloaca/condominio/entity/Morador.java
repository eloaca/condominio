package br.com.eloaca.condominio.entity;

import java.io.Serializable;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "morador")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Morador implements Serializable  {

    private static final long serialVersionUID = 1050677815179965623L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<Documento> documento;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(unique = true)
    private Apartamento apartamento;
}
