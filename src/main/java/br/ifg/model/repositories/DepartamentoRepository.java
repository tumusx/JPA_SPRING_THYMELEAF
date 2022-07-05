package br.ifg.model.repositories;

import java.util.List;

import br.ifg.model.entities.prova.Departamento;
import br.ifg.model.entities.prova.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
	List<Departamento> findAllByOrderByNome();
}

