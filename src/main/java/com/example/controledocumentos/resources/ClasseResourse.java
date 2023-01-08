package com.example.controledocumentos.resources;

import com.example.controledocumentos.dto.ClasseDTO;
import com.example.controledocumentos.entities.Classe;
import com.example.controledocumentos.services.ClasseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/classes")
public class ClasseResourse {
    private final ClasseService service;

    public ClasseResourse(ClasseService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ClasseDTO>> findAll() {
        List<ClasseDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
