package br.grupointegrado.e_cormmerce.DTO;

import br.grupointegrado.e_cormmerce.Enum.Status;
import br.grupointegrado.e_cormmerce.model.Usuario;

import java.time.LocalDate;

public record PedidoRequestDTO(LocalDate dataPedido,
                               Status status,
                               Integer idUsuario
) {
    }