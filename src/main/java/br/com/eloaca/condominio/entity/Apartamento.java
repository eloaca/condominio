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

import java.io.Serializable;
import java.util.List;

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
}
