package br.edu.ifsudestemg.corrida.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Accessors(chain = true)
public class Corredor implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private Long serialVersionUID = 1L;
    private String nome;
    private String cpf;
    private String rg;
    private Date nascimento;
}
