package com.example.controledocumentos.services;

import com.example.controledocumentos.dto.ClasseDTO;
import com.example.controledocumentos.entities.Classe;
import com.example.controledocumentos.repositories.ClasseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClasseService {

    private final ClasseRepository repository;

    public ClasseService(ClasseRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<ClasseDTO> findAll() {
        List<Classe> list = repository.findAll();

        return list.stream().map(classe -> new ClasseDTO(classe)).collect(Collectors.toList());
    }
}


