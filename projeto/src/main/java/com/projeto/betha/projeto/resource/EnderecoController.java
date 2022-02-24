package com.projeto.betha.projeto.resource;

import com.projeto.betha.projeto.enterprise.EntityNotFoundException;
import com.projeto.betha.projeto.model.Endereco;
import com.projeto.betha.projeto.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController extends AbstractResource{

    @Autowired
    private EnderecoRepository repository;

    @GetMapping
    public List<EnderecoDTO> getEndereco(){
        return repository.findAll().stream().map(p -> EnderecoDTO.toDTO(p)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EnderecoDTO getEnderecoId(@PathVariable(value = "id") Long enderecoId) throws EntityNotFoundException {
        Endereco enderecoFind = repository.findById(enderecoId)
                .orElseThrow(() -> new EntityNotFoundException("Endereço não encontrado com código: " + enderecoId));
        return EnderecoDTO.toDTO(enderecoFind);
    }

    @PostMapping
    public EnderecoDTO create(@Valid @RequestBody Endereco endereco) {
        return EnderecoDTO.toDTO(repository.save(endereco));
    }


    @PutMapping("/{id}")
    public Endereco update(@PathVariable(value = "id") Long enderecoId,
                          @RequestBody Endereco endereco) throws EntityNotFoundException {
         Endereco enderecoFind = repository.findById(enderecoId)
                .orElseThrow(() -> new EntityNotFoundException("Endereço não encontrado com código: " + enderecoId));

        enderecoFind.setId(endereco.getId());
        enderecoFind.setPais(endereco.getPais());
        enderecoFind.setEstado(endereco.getEstado());
        enderecoFind.setCidade(endereco.getCidade());
        enderecoFind.setCep(endereco.getCep());
        enderecoFind.setLogradouro(endereco.getLogradouro());
        enderecoFind.setNumeroEndereco(endereco.getNumeroEndereco());
        enderecoFind.setPrincipal(endereco.getPrincipal());
        enderecoFind.setCliente(endereco.getCliente());
        return repository.save(enderecoFind);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long enderecoId) throws EntityNotFoundException {
        Endereco enderecoFind = repository.findById(enderecoId)
                .orElseThrow(() -> new EntityNotFoundException("Endereço não encontrado com código: " + enderecoId));

        repository.delete(enderecoFind);
        return ResponseEntity.noContent().build();
    }


}
