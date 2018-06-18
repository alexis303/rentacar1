/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.VehiculoModel;
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
@RequestMapping("/urlVehiculo")
public class VehiculoController {
    
       @GetMapping()
    public List<VehiculoModel> listarTodos() {
        
        return VehiculoModel.vehiculo;
        
    }

    
    @GetMapping("/{id}")
    public VehiculoModel muestraUnVehiculo(@PathVariable String id) {
        VehiculoModel vehiculos = new VehiculoModel();
        
        return vehiculos.buscaVehiculo(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<VehiculoModel> editaVehiculos(@PathVariable String id, @RequestBody VehiculoModel vehiculoEditar) {
        
        VehiculoModel vehiculos = new VehiculoModel();
        
        
        
        return new ResponseEntity<>(vehiculos.editarVehiculo(Integer.parseInt(id), vehiculoEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> agregarVehiculo(@RequestBody VehiculoModel nuevoVehiculo) {
        
        VehiculoModel vehiculos = new VehiculoModel();
        
        if (vehiculos.nuevoVehiculo(nuevoVehiculo)) {
            
            return new ResponseEntity<>(HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        VehiculoModel vehiculos = new VehiculoModel();
        
        if (vehiculos.eliminarVehiculo(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        
        
    }
}
