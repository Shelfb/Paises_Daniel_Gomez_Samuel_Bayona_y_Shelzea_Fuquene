package com.paises.java.paises2902274.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paises.java.paises2902274.entidades.Pais;
import com.paises.java.paises2902274.repositorios.PaisRepositorio;

@Service 
public class PaisServicioImpl implements IPaisServicio {

      //Referencia al PaisRepositorio
      @Autowired
      private PaisRepositorio repositorio;

      @Override
      @Transactional(readOnly = true)
      public List<Pais> findAll() {
           return (List<Pais>)repositorio.findAll();
      }

      @Override
      @Transactional(readOnly = true)
      public Optional<Pais> findById(Long id) {
            return repositorio.findById(id);
      }

      @Override
      @Transactional
      public Pais save(Pais pais) {
            return repositorio.save(pais);
      }

      @Override
      public Optional<Pais> delete(Long id) {
            //1. Seleccionar  el pais por id
            Optional<Pais> paisDb = repositorio.findById(id);
            paisDb.ifPresent( p -> {
            //2. Si existe el pais, borrelo de db
                  repositorio.delete(p);
            });
            return paisDb;
      }

}
