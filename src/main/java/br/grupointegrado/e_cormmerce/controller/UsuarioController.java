package br.grupointegrado.e_cormmerce.controller;

import br.grupointegrado.e_cormmerce.DTO.UsuarioRequestDTO;
import br.grupointegrado.e_cormmerce.model.Usuario;
import br.grupointegrado.e_cormmerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public List<Usuario> findAll() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable Integer id){
        return this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuario não foi encontrado"));
    }

    @PostMapping
    public Usuario save(@RequestBody UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setCpf(dto.cpf());
        usuario.setTelefone(dto.telefone());
        usuario.setEmail(dto.email());
        usuario.setEndereco(dto.endereco());

        return this.repository.save(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        Usuario usuario = this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuario não foi encontrado"));
        this.repository.delete(usuario);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody UsuarioRequestDTO dto){
        Usuario usuario = this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuario não foi encontrado"));

        usuario.setNome(dto.nome());
        usuario.setCpf(dto.cpf());
        usuario.setTelefone(dto.telefone());
        usuario.setEmail(dto.email());
        usuario.setEndereco(dto.endereco());

        this.repository.save(usuario);
        return ResponseEntity.ok(usuario);
    }
}
