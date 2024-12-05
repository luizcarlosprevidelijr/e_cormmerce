package br.grupointegrado.e_cormmerce.DTO;

public record UsuarioRequestDTO(String nome,
                                String cpf,
                                String telefone,
                                String email,
                                String endereco
) {
    }