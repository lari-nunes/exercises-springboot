package br.com.larissa.AulaJava.modelo;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;


@Entity
@Table(name = "pessoas")
@Data
public class PessoaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String sexo;

    public PessoaModel() {
    }
}
