package com.projeto.betha.projeto.repository;

import com.projeto.betha.projeto.model.Cliente;
import com.projeto.betha.projeto.model.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelefoneRepository  extends JpaRepository<Telefone, Long> {
    List<Telefone> findByNumero(String numero);
    List<Telefone> findByCliente(Cliente cliente);
}
