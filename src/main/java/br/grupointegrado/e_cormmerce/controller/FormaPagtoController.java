package br.grupointegrado.e_cormmerce.controller;

import br.grupointegrado.e_cormmerce.model.FormaPagto;
import br.grupointegrado.e_cormmerce.repository.FormaPagtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formapagto")
public class FormaPagtoController {

    @Autowired
    private FormaPagtoRepository repository;

    @GetMapping
    public List<FormaPagto> findAll() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public FormaPagto findById(@PathVariable Integer id) {
        return this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Forma de pagamento não foi encontrado"));
    }
}
