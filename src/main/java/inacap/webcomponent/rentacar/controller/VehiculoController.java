/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.VehiculoModel;
import inacap.webcomponent.rentacar.repository.VehiculoRepository;
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
@RequestMapping("/Vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @GetMapping()
    public Iterable<VehiculoModel> listarTodos() {

        return vehiculoRepository.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoModel> muestraUnVehiculo(@PathVariable String id) {
        Optional<VehiculoModel> vehiculoOptional = vehiculoRepository.findById(Integer.parseInt(id));

        if (vehiculoOptional.isPresent()) {
            VehiculoModel vehiculoEncontrada = vehiculoOptional.get();
            return new ResponseEntity<>(vehiculoEncontrada, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehiculoModel> editaVehiculo(@PathVariable String id, @RequestBody VehiculoModel vehiculoEditar) {

      
        Optional<VehiculoModel> vehiculoOptional = vehiculoRepository.findById(Integer.parseInt(id));

        if (vehiculoOptional.isPresent()) {
            VehiculoModel vehiculoEncontrada = vehiculoOptional.get();
            vehiculoEditar.setIdVehiculo(vehiculoEncontrada.getIdVehiculo());

            vehiculoRepository.save(vehiculoEditar);

            return new ResponseEntity<>(vehiculoEditar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> agregarVehiculo(@RequestBody VehiculoModel nuevoVehiculo) {

       nuevoVehiculo = vehiculoRepository.save(nuevoVehiculo);

        Optional<VehiculoModel> vehiculoOptional = vehiculoRepository.findById(nuevoVehiculo.getIdVehiculo());

        if (vehiculoOptional.isPresent()) {
            VehiculoModel vehiculoEncontrada = vehiculoOptional.get();
            return new ResponseEntity<>(vehiculoEncontrada, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);

        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {

     Optional<VehiculoModel> vehiculoOptional = vehiculoRepository.findById(Integer.parseInt(id));

        if (vehiculoOptional.isPresent()) {
            
            VehiculoModel vehiculoEncontrada = vehiculoOptional.get();
            vehiculoRepository.deleteById(vehiculoEncontrada.getIdVehiculo());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
