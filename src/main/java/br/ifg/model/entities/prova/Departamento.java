package br.ifg.model.entities.prova;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Departamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length = 45)
    private String nome;

    @OneToMany(mappedBy = "departamento")
    List<Funcionario> funcionario = new ArrayList<>();

    public Departamento() {
        super();
    }

    public Departamento(String nomeDepartamento) {
        this.nome = nomeDepartamento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Funcionario> getFuncionario() {
        return funcionario;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departamento)) return false;
        Departamento email1 = (Departamento) o;
        return id == email1.id && Objects.equals(nome, email1.nome) && Objects.equals(funcionario, email1.funcionario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, funcionario);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}