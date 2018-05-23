package br.edu.ifsudestemg.corrida.repository;

import br.edu.ifsudestemg.corrida.model.Corredor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorredorRepository extends CrudRepository<Corredor, Long> {
    // select * from tabela where id='id' and cpf='cpf'
    Corredor findByIdAndCpf(Long id, String cpf);
}
