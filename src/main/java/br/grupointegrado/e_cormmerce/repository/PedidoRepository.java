package br.grupointegrado.e_cormmerce.repository;

import br.grupointegrado.e_cormmerce.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
