package br.edu.ifsudestemg.corrida.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
@Accessors(chain = true)
public class Inscricao {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Corredor corredor;
    @ManyToOne
    private Corrida corrida;
}
