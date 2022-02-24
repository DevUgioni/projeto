package com.projeto.betha.projeto.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ENDERECO")
public class Endereco {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DH_CRIACAO")
    private LocalDate dhCriacao = LocalDate.now();

    @Column(name = "PAIS")
    private String pais;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "CIDADE")
    private String cidade;

    @Column(name = "CEP")
    private Integer cep;

    @Column(name = "LOGRADOURO")
    private String logradouro;

    @Column(name = "NUMERO_ENDERECO")
    private String numeroEndereco;

    @Column(name = "PRINCIPAL")
    @Enumerated(value = EnumType.STRING)
    private Principal principal;

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

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public enum Principal {
        SIM("Sim"),
        NAO("Não");

        private final String descricao;

        Principal(final String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return this.descricao;
        }

        public String getValue() {
            return this.name();
        }
    }
}
