package com.example.controledocumentos.resources;

import com.example.controledocumentos.dto.ClasseDTO;
import com.example.controledocumentos.services.ClasseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClasseResourse {
    private final ClasseService service;

    public ClasseResourse(ClasseService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<ClasseDTO>> findAll() {
        List<ClasseDTO> list = service.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClasseDTO> findById(@PathVariable Long id) {
        ClasseDTO dto = service.findById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ClasseDTO> insert(@Valid @RequestBody ClasseDTO dto) {
        ClasseDTO newDto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newDto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ClasseDTO> update(@PathVariable Long id, @Valid @RequestBody ClasseDTO dto) {
        dto = service.update(id,dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
