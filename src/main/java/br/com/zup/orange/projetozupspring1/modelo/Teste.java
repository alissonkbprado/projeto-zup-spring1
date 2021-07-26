package br.com.zup.orange.projetozupspring1.modelo;

import br.com.zup.orange.projetozupspring1.valiacao.ValidaNascMenor18;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Teste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 400)
    @NotNull
    @Column(nullable = false, columnDefinition = "TEXT", length = 400)
    private String nome;

    @DateTimeFormat
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dataCadastro2;

    @DateTimeFormat
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dataCadastro3 = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}
