package br.grupointegrado.e_cormmerce.repository;

import br.grupointegrado.e_cormmerce.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
