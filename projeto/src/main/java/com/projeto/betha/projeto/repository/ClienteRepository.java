package com.projeto.betha.projeto.repository;

import com.projeto.betha.projeto.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNome(String nome);
    List<Cliente> findByNomeFantasia(String nomeFantasia);
    List<Cliente> findByTipo(String tipo);
    List<Cliente> findByCpfCnpj(String cpfCnpj);
    List<Cliente> findByEmail(String email);
    List<Cliente> findByDhNascimento(LocalDate dhNascimento);
}
