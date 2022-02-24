package com.projeto.betha.projeto.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TELEFONE")
public class Telefone {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DH_CRIACAO")
    private LocalDate dhCriacao = LocalDate.now();

    @Column(name = "NUMERO")
    private String numero;

    @ManyToOne
    @JoinColumn(name = "I_CLIENTE", referencedColumnName = "ID")
    private Cliente cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDhCriacao() {
        return dhCriacao;
    }

    public void setDhCriacao(LocalDate dhCriacao) {
        this.dhCriacao = dhCriacao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
