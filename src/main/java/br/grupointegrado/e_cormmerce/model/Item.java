package br.grupointegrado.e_cormmerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column(name = "preco")
    private BigDecimal preco;

//    @OneToMany(mappedBy = "item")
//    @JsonIgnoreProperties("item")
//    private List<AuditPrecoItem> auditPrecoItem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
//
//    public List<AuditPrecoItem> getAuditPrecoItem() {
//        return auditPrecoItem;
//    }
//
//    public void setAuditPrecoItem(List<AuditPrecoItem> auditPrecoItem) {
//        this.auditPrecoItem = auditPrecoItem;
//    }
}
