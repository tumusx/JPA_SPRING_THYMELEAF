package br.ifg.model.repositories;

import br.ifg.model.entities.prova.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmailRepository extends JpaRepository<Email, Long> { }
