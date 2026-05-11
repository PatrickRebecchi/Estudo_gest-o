package br.com.javapatrick.gestao_custos.entity;

import br.com.javapatrick.gestao_custos.entity.enums.Categoria;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "despesas")
@NoArgsConstructor
@AllArgsConstructor
public class Despesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Descricao obrigadoria")
    private String descricao;
    @NotBlank(message = "Data da despesa")
    private LocalDate data;
    @NotBlank(message = "Valor da despesa")
    private BigDecimal valor;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    @CreatedDate
    private LocalDate dataCriacao;

    @ManyToOne
    @JoinColumn(name = "user_id") // FK correta
    private User user;
}
