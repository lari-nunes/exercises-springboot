package br.com.larissa.AulaJava.repository;

import br.com.larissa.AulaJava.modelo.Pessoa;
import br.com.larissa.AulaJava.modelo.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {

}
