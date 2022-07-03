package br.ifg.seeders;

import java.util.List;

import javax.transaction.Transactional;

import br.ifg.model.entities.Editora;
import br.ifg.model.repositories.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.ifg.model.entities.Categoria;
import br.ifg.model.entities.Livro;
import br.ifg.model.entities.Resenha;
import br.ifg.model.repositories.CategoriaRepository;
import br.ifg.model.repositories.LivroRepository;

@Component
@Transactional
public class DatabaseSeeder implements CommandLineRunner {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private EditoraRepository editoraRepository;

	@SuppressWarnings("unused")
	@Override
	public void run(String... args) throws Exception {

		if (true) {

			Categoria c1 = new Categoria("Motivacional");
			categoriaRepository.save(c1);

			Categoria c2 = new Categoria("Romance");
			categoriaRepository.save(c2);
			
			Categoria c3 = new Categoria("Negócios e Economia");
			categoriaRepository.save(c3);

			Editora editora = new Editora("Libido");
			editoraRepository.save(editora);
			Editora editora2 = new Editora("Parafirma");
			editoraRepository.save(editora2);
			Editora editora3 = new Editora("Libds");
			editoraRepository.save(editora3);


			Livro lv;

			lv = new Livro("8568014054", "Atitude Mental e Positiva",editora, c1,
					new Resenha("Se você deseja mudar sua vida para melhor ..."));
			livroRepository.save(lv);

			lv = new Livro("8576840626", "Os 7 Hábitos das Pessoas Altamente Eficazes", editora2, c1,
					new Resenha("É uma abordagem holística e integrada à solução de problemas ..."));
			livroRepository.save(lv);

			lv = new Livro("8551004867", "Um Lugar Bem Longe Daqui",editora3, c2,
					new Resenha("Kya sobreviveu por anos sozinha no pantano..."));
			livroRepository.save(lv);

			lv = new Livro("655544049", "Atitude Positiva Diária", editora, c1,
					new Resenha("O autor nos mostrar o poder  de frases positivas..."));
			livroRepository.save(lv);

			lv = new Livro("8551005456", "Um Caminho para a Liberdade",editora2, c2,
					new Resenha("Cinco mulheres vão enfrentar uma cidade inteira por ..."));
			livroRepository.save(lv);

			// update
			Livro lvUpdate = livroRepository.findById(1L).get();
			lvUpdate.setTitulo("Atitude mental e positiva - Título Alterado");
			livroRepository.save(lvUpdate);

			// deleteById
			Livro lvDelete = livroRepository.findByIsbn("655544049");
			livroRepository.deleteById(lvDelete.getId());

			// findAll
			List<Livro> lista = livroRepository.findAll();
			for (Livro livro : lista) {
				//System.out.println(livro);
			}

			// findAllByOrderByIdDesc
			lista = livroRepository.findAllByOrderByIdDesc();
			for (Livro livro : lista) {
				//System.out.println(livro);
			}

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