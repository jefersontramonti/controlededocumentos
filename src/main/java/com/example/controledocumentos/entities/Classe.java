package com.example.controledocumentos.entities;

import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;


//essa classe cria Classe: termoformadora, extrusora


@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_classe")
public class Classe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
