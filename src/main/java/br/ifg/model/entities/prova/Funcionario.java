package br.ifg.model.entities.prova;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length = 35)
    private String nome;

    @Column(nullable = false, unique = true, length = 35)
    private String sobrenome;

    @ManyToOne
    @JoinColumn(name = "fk_departamento", nullable = false)
    private Departamento departamento;

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    @OneToOne
    @JoinColumn(name = "fk_email", nullable = false)
    private Email email;


    public Funcionario() {
        super();
    }

    public Funcionario(long id, String nome, String sobrenome, Departamento departamento, Email email) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.departamento = departamento;
        this.email = email;
    }

    public Funcionario(String nome, String sobrenome, Departamento departamento, Email email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.departamento = departamento;
        this.email = email;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario)) return false;
        Funcionario that = (Funcionario) o;
        return getId() == that.getId() && getNome().equals(that.getNome()) && getSobrenome().equals(that.getSobrenome()) && departamento.equals(that.departamento) && email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getSobrenome(), departamento, email);
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
