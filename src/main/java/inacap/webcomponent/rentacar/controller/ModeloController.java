/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.ModeloModel;
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
@RequestMapping("/urlModelo")
public class ModeloController {
    
     @GetMapping()
    public List<ModeloModel> listarTodos() {
        
        return ModeloModel.modelo;
        
    }

    
    @GetMapping("/{id}")
    public ModeloModel muestraUnModelo(@PathVariable String id) {
        ModeloModel modelos = new ModeloModel();
        
        return modelos.buscaModelo(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ModeloModel> editaModelo(@PathVariable String id, @RequestBody ModeloModel ModeloEditar) {
        
        ModeloModel modelos = new ModeloModel();
        
        
        
        return new ResponseEntity<>(modelos.editarModelo(Integer.parseInt(id), ModeloEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> agregarModelo(@RequestBody ModeloModel nuevoModelo) {
        
        ModeloModel modelos = new ModeloModel();
        
        if (modelos.nuevoModelo(nuevoModelo)) {
            
            return new ResponseEntity<>(HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        ModeloModel modelos = new ModeloModel();
        
        if (modelos.eliminarModelo(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        
        
    }
    
}
