package br.grupointegrado.e_cormmerce.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ItemRequestDTO(String nome,
                             String descricao,
                             BigDecimal preco
) {
}