/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.TipoPersonaModel;
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
@RequestMapping("/urlTipoPersona")
public class TipoPersonaController {
    
    @GetMapping()
    public List<TipoPersonaModel> listarTodos() {
        
        return TipoPersonaModel.tipoPersona;
        
    }

    
    @GetMapping("/{id}")
    public TipoPersonaModel muestraUnTipoPersona(@PathVariable String id) {
        TipoPersonaModel tiposDePersonas = new TipoPersonaModel();
        
        return tiposDePersonas.buscaTipoPersona(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TipoPersonaModel> editaTipoPersona(@PathVariable String id, @RequestBody TipoPersonaModel tipoPersonaEditar) {
        
        TipoPersonaModel tiposDePersonas = new TipoPersonaModel();
        
        
        
        return new ResponseEntity<>(tiposDePersonas.editarTipoPersona(Integer.parseInt(id), tipoPersonaEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> agregarTipoPersona(@RequestBody TipoPersonaModel nuevoTipoPersona) {
        
        TipoPersonaModel tiposDePersonas  = new TipoPersonaModel();
        
        if (tiposDePersonas.nuevoTipoPersona(nuevoTipoPersona)) {
            
            return new ResponseEntity<>(HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        TipoPersonaModel tiposDePersonas = new TipoPersonaModel();
        
        if (tiposDePersonas.eliminarTipoPersona(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        
        
    }
}
