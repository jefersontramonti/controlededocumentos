package com.example.controledocumentos.entities;


import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;


//essa classe cria Classe: termoformadora, extrusora

@Entity
@Table(name = "tb_classe")
public class Classe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = Instant.now();
    }


    public Classe() {
    }

    public Classe(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Classe(String name) {
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

    public Instant getCreatedAt() {
        return createdAt;
    }


    public Instant getUpdatedAt() {
        return updatedAt;
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
