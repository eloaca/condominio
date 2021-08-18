package br.com.eloaca.condominio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.util.List;

@Entity(name = "apartamento")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Apartamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bloco;

    private String numero;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Morador> morador;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Visitante> visitante;
}
