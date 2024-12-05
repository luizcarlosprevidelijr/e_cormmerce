package br.grupointegrado.e_cormmerce.controller;

import br.grupointegrado.e_cormmerce.DTO.AuditPrecoItemRequestDTO;
import br.grupointegrado.e_cormmerce.model.AuditPrecoItem;
import br.grupointegrado.e_cormmerce.model.Item;
import br.grupointegrado.e_cormmerce.repository.AuditPrecoItemRepository;
import br.grupointegrado.e_cormmerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auditprecoitem")
public class AuditPrecoItemController {

    @Autowired
    private AuditPrecoItemRepository repository;

    @Autowired
    private ItemRepository itemRepository;
    @GetMapping
    public List<AuditPrecoItem> findAll() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public AuditPrecoItem findById(@PathVariable Integer id){
        return this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Audit preço item não foi encontrado"));
    }

    @PostMapping
    public AuditPrecoItem save(@RequestBody AuditPrecoItemRequestDTO dto) {
        Item item = itemRepository.findById(dto.itemId())
                .orElseThrow(() -> new IllegalArgumentException("Item não encontrado"));

        AuditPrecoItem auditPrecoItem = new AuditPrecoItem();

        auditPrecoItem.setPrecoAntigo(dto.precoAntigo());
        auditPrecoItem.setPrecoNovo(dto.precoNovo());
        auditPrecoItem.setDataAlteracao(dto.dataAlteracao());
        auditPrecoItem.setItem(item);

        return this.repository.save(auditPrecoItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        AuditPrecoItem auditPrecoItem = this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Item não foi encontrado"));
        this.repository.delete(auditPrecoItem);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuditPrecoItem> update(@PathVariable Integer id, @RequestBody AuditPrecoItemRequestDTO dto) {
        AuditPrecoItem auditPrecoItem = this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Audit preço item não foi encontrado"));

        auditPrecoItem.setPrecoAntigo(dto.precoAntigo());
        auditPrecoItem.setPrecoNovo(dto.precoNovo());
        auditPrecoItem.setDataAlteracao(dto.dataAlteracao());

        this.repository.save(auditPrecoItem);
        return ResponseEntity.ok(auditPrecoItem);
    }
}

