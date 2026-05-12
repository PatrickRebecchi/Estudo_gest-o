package br.com.javapatrick.gestao_custos.entity;

import br.com.javapatrick.gestao_custos.dto.request.UserCadastrarRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nome obrigatorio")
    private String nome;
    @NotBlank(message = "Email obrigatorio")
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Despesa> despesas;

    public User(UserCadastrarRequest dto) {
        this.nome = dto.nome();
        this.email = dto.email();
    }

}
