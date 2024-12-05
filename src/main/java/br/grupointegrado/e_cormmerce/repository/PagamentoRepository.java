package br.grupointegrado.e_cormmerce.repository;

import br.grupointegrado.e_cormmerce.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}
