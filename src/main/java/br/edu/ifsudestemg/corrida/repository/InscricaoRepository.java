package br.edu.ifsudestemg.corrida.repository;

import br.edu.ifsudestemg.corrida.model.Inscricao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscricaoRepository extends CrudRepository<Inscricao, Long> {
}
