package com.paises.java.paises2902274.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "paises")
public class Pais {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      private String capital;
      private String nombre;
        
}
