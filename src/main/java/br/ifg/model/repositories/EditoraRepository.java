package br.ifg.model.repositories;

import br.ifg.model.entities.Editora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EditoraRepository extends JpaRepository<Editora, Long> {
    List<Editora> findAllByOrderByNome();
}
