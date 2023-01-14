package com.example.controledocumentos.dto;

import com.example.controledocumentos.entities.Classe;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClasseDTO implements Serializable {
    private Long id;
    private String name;


    public ClasseDTO(Classe entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

}
