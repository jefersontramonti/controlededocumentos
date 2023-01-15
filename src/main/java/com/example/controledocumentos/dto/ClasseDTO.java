package com.example.controledocumentos.dto;

import com.example.controledocumentos.entities.Classe;

import java.io.Serializable;


public class ClasseDTO implements Serializable {
    private Long id;
    private String name;


    public ClasseDTO() {
    }

    public ClasseDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ClasseDTO(Classe entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
