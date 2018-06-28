/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.CombustibleModel;
import inacap.webcomponent.rentacar.repository.CombustibleRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
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
@RequestMapping("/Combustible")
public class CombustibleController {
    
    @Autowired
    private CombustibleRepository  combustibleRepository;

    @GetMapping()
    public Iterable<CombustibleModel> listarTodos() {

        return combustibleRepository.findAll();

    }
    
    
    
     @GetMapping("/{id}")
    public ResponseEntity<CombustibleModel> muestraUnaCombustible(@PathVariable String id) {

        Optional<CombustibleModel> combustibleOptional =combustibleRepository.findById(Integer.parseInt(id));

        if (combustibleOptional.isPresent()) {
            CombustibleModel combustibleEncontrada = combustibleOptional.get();
            return new ResponseEntity<>(combustibleEncontrada, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<CombustibleModel> editaCombustible(@PathVariable String id, @RequestBody CombustibleModel combustibleEditar) {

        Optional<CombustibleModel> combustibleOptional = combustibleRepository.findById(Integer.parseInt(id));

        if (combustibleOptional.isPresent()) {
            CombustibleModel combustibleEncontrada = combustibleOptional.get();
            combustibleEditar.setIdCombustible(combustibleEncontrada.getIdCombustible());


           combustibleRepository.save(combustibleEditar);

            return new ResponseEntity<>(combustibleEditar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

     @PostMapping
    public ResponseEntity<?> agregarCombustible(@RequestBody CombustibleModel nuevoCombustible) {

        nuevoCombustible = combustibleRepository.save(nuevoCombustible);

        Optional<CombustibleModel> combustibleOptional = combustibleRepository.findById(nuevoCombustible.getIdCombustible());

        if (combustibleOptional.isPresent()) {
          CombustibleModel combustibleEncontrada = combustibleOptional.get();
            return new ResponseEntity<>(combustibleEncontrada, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);

        }

    }


    @DeleteMapping("/{id}")
     public ResponseEntity<?> delete(@PathVariable String id) {

        Optional<CombustibleModel> combustibleOptional = combustibleRepository.findById(Integer.parseInt(id));

        if (combustibleOptional.isPresent()) {
            
        
          CombustibleModel combustibleEncontrada = combustibleOptional.get();
         combustibleRepository.deleteById(combustibleEncontrada.getIdCombustible());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);

        }

    
     }
}
