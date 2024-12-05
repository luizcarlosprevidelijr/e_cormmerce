package br.grupointegrado.e_cormmerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table
public class Pagamento {

    @EmbeddedId
    private PagamentoPK id;

    @Column
    private BigDecimal valor;

    public PagamentoPK getId() {
        return id;
    }

    public void setId(PagamentoPK id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
