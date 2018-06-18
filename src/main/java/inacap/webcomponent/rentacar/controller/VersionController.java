/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.VersionModel;
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
@RequestMapping("/urlVersion")
public class VersionController {
    
        @GetMapping()
    public List<VersionModel> listarTodos() {
        
        return VersionModel.version;
        
    }

    
    @GetMapping("/{id}")
    public VersionModel muestraUnaVersion(@PathVariable String id) {
        VersionModel versiones = new VersionModel();
        
        return versiones.buscaVersion(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<VersionModel> editaVersion(@PathVariable String id, @RequestBody VersionModel versionEditar) {
        
        VersionModel versiones = new VersionModel();
        
        
        
        return new ResponseEntity<>(versiones.editarVersion(Integer.parseInt(id), versionEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> agregarVersion(@RequestBody VersionModel nuevaVersion) {
        
        VersionModel versiones = new VersionModel();
        
        if (versiones.nuevaVersion(nuevaVersion)) {
            
            return new ResponseEntity<>(HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        VersionModel versiones = new VersionModel();
        
        if (versiones.eliminarVersion(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        
        
    }
    
}
