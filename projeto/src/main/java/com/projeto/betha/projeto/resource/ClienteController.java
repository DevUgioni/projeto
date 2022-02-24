package com.projeto.betha.projeto.resource;

import com.projeto.betha.projeto.enterprise.EntityNotFoundException;
import com.projeto.betha.projeto.model.Cliente;
import com.projeto.betha.projeto.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController extends AbstractResource{

    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public List<ClienteDTO> getCliente(){
        return repository.findAll().stream().map(p -> ClienteDTO.toDTO(p)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ClienteDTO getClienteId(@PathVariable(value = "id") Long clienteId) throws EntityNotFoundException {
        Cliente clienteFind = repository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com código: " + clienteId));
        return ClienteDTO.toDTO(clienteFind);
    }

    @PostMapping
    public ClienteDTO create(@Valid @RequestBody Cliente cliente) {
        return ClienteDTO.toDTO(repository.save(cliente));
    }

    @PutMapping("/{id}")
    public Cliente update(@PathVariable(value = "id") Long clienteId,
                          @RequestBody Cliente cliente) throws EntityNotFoundException {
        Cliente clienteFind = repository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com código: " + clienteId));
        clienteFind.setId(cliente.getId());
        clienteFind.setNome(cliente.getNome());
        clienteFind.setNomeFantasia(cliente.getNomeFantasia());
        clienteFind.setTipo(cliente.getTipo());
        clienteFind.setCpfCnpj(cliente.getCpfCnpj());
        clienteFind.setEmail(cliente.getEmail());
        clienteFind.setDhNascimento(cliente.getDhNascimento());
        return repository.save(clienteFind);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long clienteId) throws EntityNotFoundException {
        Cliente clienteFind = repository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com código: " + clienteId));
        repository.delete(clienteFind);
        return ResponseEntity.noContent().build();
    }


}
