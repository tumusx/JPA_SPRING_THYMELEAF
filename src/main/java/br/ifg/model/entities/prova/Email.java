package br.ifg.model.entities.prova;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Email implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @OneToOne(mappedBy = "email")
    Funcionario funcionario;

    public Email() {
        super();
    }

    public Email(String emailUser) {
        this.email = emailUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email)) return false;
        Email email1 = (Email) o;
        return id == email1.id && Objects.equals(email, email1.email) && Objects.equals(funcionario, email1.funcionario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, funcionario);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}