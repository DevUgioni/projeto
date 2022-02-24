package com.projeto.betha.projeto.resource;

import com.projeto.betha.projeto.model.Cliente;
import com.projeto.betha.projeto.model.Telefone;

import java.time.LocalDate;

public class TelefoneDTO {
    private Long id;
    private LocalDate dhCriacao = LocalDate.now();
    private String numero;
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

    public static TelefoneDTO toDTO(Telefone telefone) {
        TelefoneDTO dto = new TelefoneDTO();
        dto.setId(telefone.getId());
        dto.setNumero(telefone.getNumero());
        dto.setCliente(telefone.getCliente());
        return dto;
    }

    public static Telefone fromDTO(TelefoneDTO dto) {
        Telefone entity = new Telefone();
        entity.setId(dto.getId());
        entity.setNumero(dto.getNumero());
        entity.setCliente(dto.getCliente());
        return entity;
    }
}
