/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.PersonaModel;
import inacap.webcomponent.rentacar.repository.PersonaRepository;
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
@RequestMapping("/Persona")
public class PersonaController {
    
    @Autowired
    private PersonaRepository personaRepository;
    
    @GetMapping()
    public Iterable<PersonaModel> listarTodos() {
        
        return personaRepository.findAll();
        
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<PersonaModel> muestraUnaPersona(@PathVariable String id) {
        Optional<PersonaModel> personaOptional = personaRepository.findById(Integer.parseInt(id));

        if (personaOptional.isPresent()) {
            PersonaModel personaEncontrada = personaOptional.get();
            return new ResponseEntity<>(personaEncontrada, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PersonaModel> editaPersona(@PathVariable String id, @RequestBody PersonaModel personaEditar) {
        
      Optional<PersonaModel> personaOptional = personaRepository.findById(Integer.parseInt(id));

        if (personaOptional.isPresent()) {
            PersonaModel personaEncontrada = personaOptional.get();
            personaEditar.setIdPersona(personaEncontrada.getIdPersona());

            personaRepository.save(personaEditar);

            return new ResponseEntity<>(personaEditar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> agregarPersona(@RequestBody PersonaModel nuevaPersona) {
        
        nuevaPersona = personaRepository.save(nuevaPersona);

        Optional<PersonaModel> personaOptional = personaRepository.findById(nuevaPersona.getIdPersona());

        if (personaOptional.isPresent()) {
            PersonaModel personaEncontrada = personaOptional.get();
            return new ResponseEntity<>(personaEncontrada, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);

        }
        
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
       Optional<PersonaModel> personaOptional = personaRepository.findById(Integer.parseInt(id));

        if (personaOptional.isPresent()) {
            
            PersonaModel personaEncontrada = personaOptional.get();
            personaRepository.deleteById(personaEncontrada.getIdPersona());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        
        
    }
    
}
