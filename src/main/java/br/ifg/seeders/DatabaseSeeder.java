package br.ifg.seeders;

import br.ifg.model.entities.prova.Departamento;
import br.ifg.model.entities.prova.Email;
import br.ifg.model.entities.prova.Funcionario;
import br.ifg.model.repositories.DepartamentoRepository;
import br.ifg.model.repositories.EmailRepository;
import br.ifg.model.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class DatabaseSeeder implements CommandLineRunner {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Autowired
	private EmailRepository emailRepository;

	@SuppressWarnings("unused")
	@Override
	public void run(String... args) throws Exception {

		if (true) {

			Departamento departamento = new Departamento("Motivacional");
			departamentoRepository.save(departamento);

			Email email = new Email("murillo@teste.com");
			emailRepository.save(email);


			Funcionario funcionarioType = new Funcionario("Murillo", "Alves", departamento, email);
			funcionarioRepository.save(funcionarioType);

		}

		/*
		 * 
		 * Categoria c1 = categoriaRepository.findById(1L).get();
		 * System.out.println(c1);
		 * 
		 * Resenha r1 = resenhaRepository.findById(5L).get(); System.out.println(r1);
		 * 
		 * //Teste esta operação fora do contexto desta transação //Sincronize o BD,
		 * coloque o if acima como false e teste com
		 * spring.jpa.hibernate.ddl-auto=update System.out.println(c1.getLivros());
		 * System.out.println(r1.getLivro());
		 */

	}

}