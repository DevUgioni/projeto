package com.projeto.betha.projeto.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CLIENTE")
public class Cliente {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DH_CRIACAO")
    private LocalDate dhCriacao = LocalDate.now();

    @Column(name = "NOME")
    private String nome;

    @Column(name = "NOMEFANTASIA")
    private String nomeFantasia;

    @Column(name = "TIPO")
    @Enumerated(value = EnumType.STRING)
    private Tipo tipo;

    @Column(name = "CPF_CNPJ")
    private String cpfCnpj;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "DH_NASCIMENTO")
    private LocalDate dhNascimento;

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

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
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

    public enum Tipo {
        FISICA("Física"),
        JURIDICA("Jurídica");

        private final String descricao;

        Tipo(final String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return this.descricao;
        }

        public String getValue() {
            return this.name();
        }
    }

/* .. Vinculado na class endereco / telefone

    @ManyToOne
    @JoinColumn(name = "I_ENDERECO", referencedColumnName = "ID")
    private endereco endereco;

    @ManyToOne
    @JoinColumn(name = "I_TELEFONE", referencedColumnName = "ID")
    private telefone telefone;
 */
}
