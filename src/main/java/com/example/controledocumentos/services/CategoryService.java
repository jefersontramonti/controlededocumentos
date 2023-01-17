package com.example.controledocumentos.services;

import com.example.controledocumentos.dto.CategoryDTO;
import com.example.controledocumentos.entities.Category;
import com.example.controledocumentos.repositories.CategoryRepository;
import com.example.controledocumentos.services.exceptions.DataIntegrityException;
import com.example.controledocumentos.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAllPaged(PageRequest pageRequest) {
        Page<Category> list = repository.findAll(pageRequest);

        return list.map(CategoryDTO::new);
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        Category category = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
        return new CategoryDTO(category);
    }


    @Transactional
    public CategoryDTO insert(CategoryDTO dto) {
        Category category = repository.saveAndFlush(new Category(dto.getName()));
        return new CategoryDTO(category);
    }

    @Transactional
    public CategoryDTO update(Long id, CategoryDTO dto) {
        try {
            Category category = repository.getReferenceById(id);
            category.setName(dto.getName());
            category = repository.save(category);
            return new CategoryDTO(category);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id não encontrado" + id);
        }
    }


    @Transactional
    public boolean delete(Long id) {
        try {
            return repository.findById(id)
                    .map(category -> {
                        repository.delete(category);
                        return true;
                    }).orElse(false);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Violação de Integridade");
        }
    }

}


