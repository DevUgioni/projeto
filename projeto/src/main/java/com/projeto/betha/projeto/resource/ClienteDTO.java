package com.projeto.betha.projeto.resource;

import com.projeto.betha.projeto.model.Cliente;

import java.time.LocalDate;

public class ClienteDTO {
    private Long id;
    private LocalDate dhCriacao = LocalDate.now();
    private String nome;
    private String nomeFantasia;
    private String tipo;
    private String cpfCnpj;
    private String email;
    private LocalDate dhNascimento = LocalDate.now();

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(Cliente.Tipo tipo) {
        this.tipo = tipo.getDescricao();
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDhNascimento() {
        return dhNascimento;
    }

    public void setDhNascimento(LocalDate dhNascimento) {
        this.dhNascimento = dhNascimento;
    }

    public static ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setNomeFantasia(cliente.getNomeFantasia());
        dto.setTipo(cliente.getTipo());
        dto.setCpfCnpj(cliente.getCpfCnpj());
        dto.setEmail(cliente.getEmail());
        dto.setDhNascimento(cliente.getDhNascimento());
        return dto;
    }

    public static Cliente fromDTO(ClienteDTO dto) {
        Cliente entity = new Cliente();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setNomeFantasia(dto.getNomeFantasia());
        entity.setTipo(Cliente.Tipo.valueOf(dto.getTipo()));
        entity.setCpfCnpj(dto.getCpfCnpj());
        entity.setEmail(dto.getEmail());
        entity.setDhNascimento(dto.getDhNascimento());
        return entity;
    }

}
