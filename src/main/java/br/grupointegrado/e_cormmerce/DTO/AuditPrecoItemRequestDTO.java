package br.grupointegrado.e_cormmerce.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AuditPrecoItemRequestDTO(Integer itemId,
                                       BigDecimal precoAntigo,
                                       BigDecimal precoNovo,
                                       LocalDate dataAlteracao) {
    }