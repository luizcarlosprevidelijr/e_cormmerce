package br.grupointegrado.e_cormmerce.controller;

import br.grupointegrado.e_cormmerce.DTO.ItemRequestDTO;
import br.grupointegrado.e_cormmerce.model.Item;
import br.grupointegrado.e_cormmerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private ItemRepository repository;

    @GetMapping
    public List<Item> findAll() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Item findById(@PathVariable Integer id){
        return this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Item não foi encontrado"));
    }

    @PostMapping
    public Item save(@RequestBody ItemRequestDTO dto) {
        Item item = new Item();
       item.setNome(dto.nome());
       item.setDescricao(dto.descricao());
       item.setPreco(dto.preco());

        return this.repository.save(item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        Item item = this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Item não foi encontrado"));
        this.repository.delete(item);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> update(@PathVariable Integer id, @RequestBody ItemRequestDTO dto){
        Item item = this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pedido não foi encontrado"));
        item.setNome(dto.nome());
        item.setDescricao(dto.descricao());
        item.setPreco(dto.preco());

        this.repository.save(item);
        return ResponseEntity.ok(item);
    }
}
