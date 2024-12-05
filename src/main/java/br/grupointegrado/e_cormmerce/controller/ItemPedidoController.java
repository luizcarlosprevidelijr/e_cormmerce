//package br.grupointegrado.e_cormmerce.controller;
//
//import br.grupointegrado.e_cormmerce.DTO.ItemPedidoRequestDTO;
//import br.grupointegrado.e_cormmerce.model.Item;
//import br.grupointegrado.e_cormmerce.model.ItemPedido;
//import br.grupointegrado.e_cormmerce.model.ItemPedidoPK;
//import br.grupointegrado.e_cormmerce.model.Pedido;
//import br.grupointegrado.e_cormmerce.repository.ItemPedidoRepository;
//import br.grupointegrado.e_cormmerce.repository.ItemRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/itempedido")
//public class ItemPedidoController {
//
//    @Autowired
//    private ItemPedidoRepository repository;
//
//    @Autowired
//    private ItemRepository itemRepository;
//
//    @PostMapping
//    public ItemPedidoRequestDTO save(@RequestBody ItemPedidoRequestDTO dto) {
//        ItemPedidoPK id = new ItemPedidoPK();
//        id.setPedido(new Pedido());
//        id.getPedido().setId(dto.pedidoId());
//        id.setItem(new Item());
//        id.getItem().setId(dto.ItemId());
//
//        ItemPedido itemPedido = new ItemPedido();
//        itemPedido.setId(id);
//        itemPedido.setQuantidade(dto.quantidade());
//
//        ItemPedido saved = repository.save(itemPedido);
//
//        return new ItemPedidoRequestDTO(
//                saved.getId().getPedido().getId(),
//                saved.getId().getItem().getId(),
//                saved.getQuantidade()
//        );
//    }
//
//
//    @DeleteMapping("/{idPedido}/{idItem}")
//    public ResponseEntity<Void> delete(@PathVariable Integer idPedido, @PathVariable Integer idItem) {
//
//        ItemPedidoPK id = new ItemPedidoPK();
//        id.setPedido(new Pedido());
//        id.getPedido().setId(idPedido);
//        id.setItem(new Item());
//        id.getItem().setId(idItem);
//
//        ItemPedido itemPedido = repository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("ItemPedido não encontrado"));
//
//        repository.delete(itemPedido);
//
//        return ResponseEntity.noContent().build();
//    }
//
//}
//
//
