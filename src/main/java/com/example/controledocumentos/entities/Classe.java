package com.example.controledocumentos.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

//essa classe cria Classe: termoformadora, extrusora
@Entity
@Table(name = "tb_classe")
public class Classe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Classe() {
    }

    public Classe(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Classe classe)) return false;
        return getId().equals(classe.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
