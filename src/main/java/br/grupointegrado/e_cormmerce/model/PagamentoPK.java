package br.grupointegrado.e_cormmerce.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class PagamentoPK {

    @ManyToOne
    @JoinColumn(name = "id_pedido", referencedColumnName = "id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_forma_pagto", referencedColumnName = "id")
    private FormaPagto formaPagto;


}
