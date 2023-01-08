package com.example.controledocumentos.dto;

import com.example.controledocumentos.entities.Classe;

import java.io.Serializable;

public class ClasseDTO implements Serializable {
    private Long ID;
    private String name;

    public ClasseDTO() {
    }

    public ClasseDTO(Long ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public ClasseDTO(Classe entity){
        this.ID = entity.getId();
        this.name = entity.getName();
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
