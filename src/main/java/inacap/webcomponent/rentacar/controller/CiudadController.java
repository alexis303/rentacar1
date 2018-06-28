/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.CiudadModel;
import inacap.webcomponent.rentacar.repository.CiudadRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author Alexis
 */
@RestController
@RequestMapping("/Ciudad")
public class CiudadController {
    
    @Autowired
    private CiudadRepository ciudadRepository;
    
    @GetMapping()
    public Iterable<CiudadModel> list() {
        return ciudadRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CiudadModel> muestraUnaCiudad(@PathVariable String id) {
        Optional<CiudadModel> ciudadOptional = ciudadRepository.findById(Integer.parseInt(id));

        if (ciudadOptional.isPresent()) {
            CiudadModel ciudadEncontrada = ciudadOptional.get();
            return new ResponseEntity<>(ciudadEncontrada, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CiudadModel> editaArriendo(@PathVariable String id, @RequestBody CiudadModel ciudadEditar) {

         Optional<CiudadModel> ciudadOptional = ciudadRepository.findById(Integer.parseInt(id));

        if (ciudadOptional.isPresent()) {
            CiudadModel ciudadEncontrada = ciudadOptional.get();
            ciudadEditar.setIdCiudad(ciudadEncontrada.getIdCiudad());

            ciudadRepository.save(ciudadEditar);

            return new ResponseEntity<>(ciudadEditar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<?> agregarArriendo(@RequestBody CiudadModel nuevaCiudad) {

        nuevaCiudad = ciudadRepository.save(nuevaCiudad);

        Optional<CiudadModel> ciudadOptional = ciudadRepository.findById(nuevaCiudad.getIdCiudad());

        if (ciudadOptional.isPresent()) {
            CiudadModel ciudadEncontrada = ciudadOptional.get();
            return new ResponseEntity<>(ciudadEncontrada, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);

        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {

        Optional<CiudadModel> ciudadOptional = ciudadRepository.findById(Integer.parseInt(id));

        if (ciudadOptional.isPresent()) {
            
            CiudadModel ciudadEncontrada = ciudadOptional.get();
            ciudadRepository.deleteById(ciudadEncontrada.getIdCiudad());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }
    
}
