package com.example.controledocumentos.resources;

import com.example.controledocumentos.dto.ClasseDTO;
import com.example.controledocumentos.services.ClasseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
