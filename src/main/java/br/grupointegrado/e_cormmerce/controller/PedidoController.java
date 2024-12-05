package br.grupointegrado.e_cormmerce.controller;

import br.grupointegrado.e_cormmerce.DTO.PedidoRequestDTO;
import br.grupointegrado.e_cormmerce.model.Pedido;
import br.grupointegrado.e_cormmerce.model.Usuario;
import br.grupointegrado.e_cormmerce.repository.PedidoRepository;
import br.grupointegrado.e_cormmerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Pedido> findAll() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Pedido findById(@PathVariable Integer id){
        return this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pedido não foi encontrado"));
    }

    @PostMapping
    public Pedido save(@RequestBody PedidoRequestDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.idUsuario())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não foi encontrado"));

        Pedido pedido = new Pedido();
        pedido.setDataPedido(dto.dataPedido());
        pedido.setStatus(dto.status());

        pedido.setUsuario(usuario);

        return this.repository.save(pedido);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        Pedido pedido = this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pedido não foi encontrado"));
        this.repository.delete(pedido);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> update(@PathVariable Integer id, @RequestBody PedidoRequestDTO dto) {
        Pedido pedido = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não foi encontrado"));
        Usuario usuario = usuarioRepository.findById(dto.idUsuario())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não foi encontrado"));

        pedido.setDataPedido(dto.dataPedido());
        pedido.setStatus(dto.status());

        pedido.setUsuario(usuario);

        this.repository.save(pedido);
        return ResponseEntity.ok(pedido);
    }
}
