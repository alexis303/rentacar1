/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.PersonaModel;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
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
@RequestMapping("/urlPersona")
public class PersonaController {
    
    @GetMapping()
    public List<PersonaModel> listarTodos() {
        
        return PersonaModel.persona;
        
    }

    
    @GetMapping("/{id}")
    public PersonaModel muestraUnaPersona(@PathVariable String id) {
        PersonaModel personas = new PersonaModel();
        
        return personas.buscaPersona(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PersonaModel> editaPersona(@PathVariable String id, @RequestBody PersonaModel personaEditar) {
        
        PersonaModel personas = new PersonaModel();
        
        
        
        return new ResponseEntity<>(personas.editarPersona(Integer.parseInt(id), personaEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> agregarPersona(@RequestBody PersonaModel nuevaPersona) {
        
        PersonaModel personas = new PersonaModel();
        
        if (personas.nuevaPersona(nuevaPersona)) {
            
            return new ResponseEntity<>(HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        PersonaModel personas = new PersonaModel();
        
        if (personas.eliminarPersona(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        
        
    }
    
}
