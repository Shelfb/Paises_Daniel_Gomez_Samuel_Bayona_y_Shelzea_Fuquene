package com.paises.java.paises2902274.controlador;

import org.springframework.web.bind.annotation.RestController;

import com.paises.java.paises2902274.entidades.Pais;
import com.paises.java.paises2902274.servicios.PaisServicioImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/pais")


public class PaisControlador {

      @Autowired
      private PaisServicioImpl servicio;

      @GetMapping
      public List<Pais> mostrarPais(){
            //Permite buscar todos los paises en bases de datos utilizando el servicio
            return servicio.findAll();
            

      }

      //Traer un unico país por id
      @GetMapping("/{id}")
      public Pais mostrarPaisPorId(@PathVariable Long id){
            Optional<Pais> optPais = servicio.findById(id);
            return optPais.get();
      }
      
      //Grabar país en bd
      @PostMapping
      public Pais crearPais(@RequestBody Pais paisGrabar) {
          Pais paisnew = servicio.save(paisGrabar);

          return paisnew;
      }
      
      //Ruta para actualizar un país
      @PutMapping("/{id}")
      public Pais actualizarPais (@PathVariable Long id, 
                                    @RequestBody Pais paisUpd) {
      //buscar pais por id
            Pais p = servicio.findById(id).get();
            p.setCapital(paisUpd.getCapital());
            p.setNombre(paisUpd.getNombre());
            servicio.save(p);
      
            return servicio.save(p);
      }

      //Ruta para eliminar un país
      @DeleteMapping("/{id}")
      public Pais deletePais(@PathVariable Long id) {
            return servicio.delete(id).get();
      }
}
