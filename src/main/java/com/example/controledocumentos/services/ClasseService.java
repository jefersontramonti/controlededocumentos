package com.example.controledocumentos.services;

import com.example.controledocumentos.dto.ClasseDTO;
import com.example.controledocumentos.entities.Classe;
import com.example.controledocumentos.repositories.ClasseRepository;
import com.example.controledocumentos.services.exceptions.EntityNotFoundException;
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

        return list.stream().map(ClasseDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ClasseDTO findById(Long id) {
        Classe classe = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));
        return new ClasseDTO(classe);
    }


    @Transactional
    public ClasseDTO insert(ClasseDTO dto) {
        Classe classe = repository.saveAndFlush(new Classe(dto.getName()));
        return new ClasseDTO(classe);
    }


    @Transactional
    public ClasseDTO update(Long id, ClasseDTO dto) {
        Classe classe = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));
        classe.setName(dto.getName());
        classe = repository.save(classe);
        dto.setId(classe.getId());
        return dto;
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }


}


