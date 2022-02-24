package com.projeto.betha.projeto.repository;

import com.projeto.betha.projeto.model.Cliente;
import com.projeto.betha.projeto.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository  extends JpaRepository<Endereco, Long> {
    List<Endereco> findByNumeroEndereco(String numero);
    List<Endereco> findByCliente(Cliente cliente);
}
