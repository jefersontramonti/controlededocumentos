package com.example.controledocumentos.resources;

import com.example.controledocumentos.entities.Classe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/classes")
public class ClasseResourse {
    @GetMapping
    public ResponseEntity<List<Classe>> findAll() {
        List<Classe> list = new ArrayList<>();
        list.add(new Classe(1L, "Extrusora"));
        list.add(new Classe(2L, "Termoformadora"));
        return ResponseEntity.ok(list);
    }
}
