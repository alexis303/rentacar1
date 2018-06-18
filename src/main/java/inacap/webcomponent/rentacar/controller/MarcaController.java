/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.MarcaModel;
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
@RequestMapping("/urlMarca")
public class MarcaController {
    
    @GetMapping()
     
    public List<MarcaModel> list() {
        return MarcaModel.marca;
    }
    
     @GetMapping("/{id}")
    public MarcaModel muestraUnaMarca(@PathVariable String id) {
        MarcaModel Marcas = new MarcaModel();
        
        return Marcas.buscaMarca(Integer.parseInt(id));
    }
    
   @PutMapping("/{id}")
    public ResponseEntity<MarcaModel> editaMarca(@PathVariable String id, @RequestBody MarcaModel marcaEditar) {
        
        MarcaModel marcas = new MarcaModel();
        
        
        
        return new ResponseEntity<>(marcas.editarMarca(Integer.parseInt(id), marcaEditar), HttpStatus.OK);
    }
    
    
    @PostMapping
    public ResponseEntity<?> agregarMarca(@RequestBody MarcaModel nuevaMarca) {
        
        MarcaModel marcas = new MarcaModel();
        
        if (marcas.nuevaMarca(nuevaMarca)) {
            
            return new ResponseEntity<>(HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        MarcaModel marcas = new MarcaModel();
        
        if (marcas.eliminarMarca(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        
        
    }
    
}
