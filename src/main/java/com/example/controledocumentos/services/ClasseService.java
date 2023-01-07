package com.example.controledocumentos.services;

import com.example.controledocumentos.entities.Classe;
import com.example.controledocumentos.repositories.ClasseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseService {

    private final ClasseRepository repository;

    public ClasseService(ClasseRepository repository) {
        this.repository = repository;
    }

    public List<Classe> findAll(){
        return repository.findAll();
    }
}
