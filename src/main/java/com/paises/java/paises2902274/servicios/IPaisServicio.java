package com.paises.java.paises2902274.servicios;

import java.util.List;
import java.util.Optional;

import com.paises.java.paises2902274.entidades.Pais;

public interface IPaisServicio {

        //Metodos de la CRUD que
        //se implementaran en el software
        List<Pais> findAll();
        //Seleccionar un pais por el id
        Optional<Pais> findById(Long id);
        //guardar un pais(nuevo a para actualizar)
        Pais save(Pais pais);
        //Delete pais
        Optional<Pais> delete(Long id);
}
