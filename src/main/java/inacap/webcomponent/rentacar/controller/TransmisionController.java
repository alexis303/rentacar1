/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.TransmisionModel;
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
@RequestMapping("/urlTransmision")
public class TransmisionController {
    
        @GetMapping()
    public List<TransmisionModel> listarTodos() {
        
        return TransmisionModel.transmision;
        
    }

    
    @GetMapping("/{id}")
    public TransmisionModel muestraUnaTransmision(@PathVariable String id) {
        TransmisionModel transmisiones = new TransmisionModel();
        
        return transmisiones.buscatransmision(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TransmisionModel> editaTransmision(@PathVariable String id, @RequestBody TransmisionModel transmisionEditar) {
        
        TransmisionModel transmisiones = new TransmisionModel();
        
        
        
        return new ResponseEntity<>(transmisiones.editarTransmision(Integer.parseInt(id), transmisionEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> agregarTransmision(@RequestBody TransmisionModel nuevaTransmision) {
        
        TransmisionModel transmisiones = new TransmisionModel();
        
        if (transmisiones.nuevaTransmision(nuevaTransmision)) {
            
            return new ResponseEntity<>(HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        TransmisionModel transmisiones = new TransmisionModel();
        
        if (transmisiones.eliminarTransmision(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        
        
    }
    
}
