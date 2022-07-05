package br.ifg.model.repositories;

import java.util.List;

import br.ifg.model.entities.prova.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	List<Funcionario> findAllByOrderByIdDesc();
}


