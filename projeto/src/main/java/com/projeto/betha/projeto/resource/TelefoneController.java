package com.projeto.betha.projeto.resource;

import com.projeto.betha.projeto.enterprise.EntityNotFoundException;
import com.projeto.betha.projeto.model.Telefone;
import com.projeto.betha.projeto.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/telefones")
public class TelefoneController extends AbstractResource{

    @Autowired
    private TelefoneRepository repository;

    @GetMapping
    public List<TelefoneDTO> getTelefone(){
        return repository.findAll().stream().map(p -> TelefoneDTO.toDTO(p)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TelefoneDTO getTelefoneId(@PathVariable(value = "id") Long telefoneId) throws EntityNotFoundException {
        Telefone telefoneFind = repository.findById(telefoneId)
                .orElseThrow(() -> new EntityNotFoundException("Telefone não encontrado com código: " + telefoneId));

        return TelefoneDTO.toDTO(telefoneFind);
    }

    @PostMapping
    public TelefoneDTO create(@Valid @RequestBody Telefone telefone) {
        return TelefoneDTO.toDTO(repository.save(telefone));
    }

    @PutMapping("/{id}")
    public Telefone update(@PathVariable(value = "id") Long telefoneId,
                           @RequestBody Telefone telefone) throws EntityNotFoundException {
        Telefone telefoneFind = repository.findById(telefoneId)
                .orElseThrow(() -> new EntityNotFoundException("Telefone não encontrado com código: " + telefoneId));

        telefoneFind.setId(telefone.getId());
        telefoneFind.setNumero(telefone.getNumero());
        telefoneFind.setCliente(telefone.getCliente());
        return repository.save(telefoneFind);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long telefoneId) throws EntityNotFoundException {
        Telefone telefoneFind = repository.findById(telefoneId)
                .orElseThrow(() -> new EntityNotFoundException("Telefone não encontrado com código: " + telefoneId));

        repository.delete(telefoneFind);

        return ResponseEntity.noContent().build();
    }

}
