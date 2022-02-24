package com.projeto.betha.projeto.resource;

import com.projeto.betha.projeto.model.Cliente;
import com.projeto.betha.projeto.model.Endereco;

import java.time.LocalDate;

public class EnderecoDTO {
    private Long id;
    private LocalDate dhCriacao = LocalDate.now();
    private String pais;
    private String estado;
    private String cidade;
    private Integer cep;
    private String logradouro;
    private String numeroEndereco;
    private String principal;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(Endereco.Principal principal) {
        this.principal = principal.getDescricao();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public static EnderecoDTO toDTO(Endereco endereco) {
        EnderecoDTO dto = new EnderecoDTO();
        dto.setId(endereco.getId());
        dto.setPais(endereco.getPais());
        dto.setEstado(endereco.getEstado());
        dto.setCidade(endereco.getCidade());
        dto.setCep(endereco.getCep());
        dto.setLogradouro(endereco.getLogradouro());
        dto.setNumeroEndereco(endereco.getNumeroEndereco());
        dto.setPrincipal(endereco.getPrincipal());
        dto.setCliente(endereco.getCliente());
        return dto;
    }

    public static Endereco fromDTO(EnderecoDTO dto) {
        Endereco entity = new Endereco();
        entity.setId(dto.getId());
        entity.setPais(dto.getPais());
        entity.setEstado(dto.getEstado());
        entity.setCidade(dto.getCidade());
        entity.setCep(dto.getCep());
        entity.setLogradouro(dto.getLogradouro());
        entity.setNumeroEndereco(dto.getNumeroEndereco());
        entity.setPrincipal(Endereco.Principal.valueOf(dto.getPrincipal()));
        entity.setCliente(dto.getCliente());
        return entity;
    }
}
