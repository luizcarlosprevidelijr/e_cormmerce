package br.grupointegrado.e_cormmerce.repository;

import br.grupointegrado.e_cormmerce.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
