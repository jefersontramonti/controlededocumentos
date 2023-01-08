package com.example.controledocumentos.services;

import com.example.controledocumentos.entities.Classe;
import com.example.controledocumentos.repositories.ClasseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClasseService {

    private final ClasseRepository repository;

    public ClasseService(ClasseRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Classe> findAll() {
        return repository.findAll();
    }
}


