package br.ifg.controller;

import br.ifg.model.entities.prova.Funcionario;
import br.ifg.model.repositories.DepartamentoRepository;
import br.ifg.model.repositories.EmailRepository;
import br.ifg.model.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("livros")
public class FuncionarioController {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    DepartamentoRepository departamentoRepository;
    @Autowired
    EmailRepository emailRepository;

    @GetMapping("/listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("/livros/listar");
        mv.addObject("listaLivros", funcionarioRepository.findAll());
        return mv;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar(Funcionario livro) {
        ModelAndView mv = new ModelAndView("/livros/cadastrar");
        mv.addObject("listaCategoria", departamentoRepository.findAllByOrderByNome());
        return mv;
    }

    @PostMapping("/salvar")
    public String salvar(Funcionario livro, RedirectAttributes attr) {
        if (livro.getSobrenome().isEmpty() || livro.getNome().isEmpty()) {
            attr.addFlashAttribute("fail", "Não foi possível inserir");
        }
        try {
            funcionarioRepository.save(livro);
            attr.addFlashAttribute("success", "Registro inserido com sucesso");
        } catch (Exception e) {
            attr.addFlashAttribute("fail", "Não foi possível inserir");
        }
        return "redirect:/livros/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView preEditar(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("/livros/cadastrar");
        mv.addObject("livro", funcionarioRepository.findById(id).get());
        mv.addObject("listaCategoria", departamentoRepository.findAllByOrderByNome());
        return mv;
    }

    @PostMapping("/editar")
    public String editar(Funcionario livro, RedirectAttributes attr) {

        try {
            funcionarioRepository.save(livro);
            attr.addFlashAttribute("success", "Registro editado com sucesso");
        } catch (Exception e) {
            attr.addFlashAttribute("fail", "Não foi possível editar");
        }

        return "redirect:/livros/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {

        try {
            funcionarioRepository.deleteById(id);
            attr.addFlashAttribute("success", "Registro deletado com sucesso");
        } catch (Exception e) {
            attr.addFlashAttribute("fail", "Não foi possível deletar");
        }

        return "redirect:/livros/listar";
    }

}
