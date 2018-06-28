/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.TraccionModel;
import inacap.webcomponent.rentacar.repository.TraccionRepository;
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
 * @author 19798398-1
 */
@RestController
@RequestMapping("/Traccion")
public class TraccionController {
    
    @Autowired
    private TraccionRepository traccionRepository;
    
       @GetMapping()
    public Iterable<TraccionModel> listarTodos() {
        
        return traccionRepository.findAll();
        
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<TraccionModel> muestraUnaTraccion(@PathVariable String id) {

        Optional<TraccionModel> traccionOptional = traccionRepository.findById(Integer.parseInt(id));

        if (traccionOptional.isPresent()) {
            TraccionModel traccionEncontrada = traccionOptional.get();
            return new ResponseEntity<>(traccionEncontrada, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    
    @PutMapping("/{id}")
    public ResponseEntity<TraccionModel> editaTraccion(@PathVariable String id, @RequestBody TraccionModel traccionEditar) {

        Optional<TraccionModel> traccionOptional = traccionRepository.findById(Integer.parseInt(id));

        if (traccionOptional.isPresent()) {
            TraccionModel traccionEncontrada = traccionOptional.get();
            traccionEditar.setIdTraccion(traccionEncontrada.getIdTraccion());
            
            traccionRepository.save(traccionEditar);
            

            return new ResponseEntity<>(traccionEditar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
    
    @PostMapping
    public ResponseEntity<?> agregarTraccion(@RequestBody TraccionModel nuevaTraccion) {
        
       nuevaTraccion = traccionRepository.save(nuevaTraccion);

        Optional<TraccionModel> traccionOptional = traccionRepository.findById(nuevaTraccion.getIdTraccion());

        if (traccionOptional.isPresent()) {
            TraccionModel traccionEncontrada =traccionOptional.get();
            return new ResponseEntity<>(traccionEncontrada, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);

        }

    }
  
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
      Optional<TraccionModel> traccionOptional = traccionRepository.findById(Integer.parseInt(id));

        if (traccionOptional.isPresent()) {
            
            TraccionModel traccionEncontrada = traccionOptional.get();
            traccionRepository.deleteById(traccionEncontrada.getIdTraccion());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }  
        
        
    
    
}
