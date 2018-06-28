/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.TipoVehiculoModel;
import inacap.webcomponent.rentacar.repository.TipoVehiculoRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
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


@RestController
@RequestMapping("/TipoVehiculo")
public class TipoVehiculoController {
    
        @Autowired
        private TipoVehiculoRepository tvehiculoRepository;
    
        @GetMapping()
    public Iterable<TipoVehiculoModel> listarTodos() {
        
        return tvehiculoRepository.findAll();
        
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<TipoVehiculoModel> muestraUnTipoVehiculo(@PathVariable String id) {

        Optional<TipoVehiculoModel> tvehiculoOptional = tvehiculoRepository.findById(Integer.parseInt(id));

        if (tvehiculoOptional.isPresent()) {
            TipoVehiculoModel tvehiculoEncontrada = tvehiculoOptional.get();
            return new ResponseEntity<>(tvehiculoEncontrada, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TipoVehiculoModel> editaTipoVehiculo(@PathVariable String id, @RequestBody TipoVehiculoModel tvehiculoEditar) {

        Optional<TipoVehiculoModel> tvehiculoOptional = tvehiculoRepository.findById(Integer.parseInt(id));

        if (tvehiculoOptional.isPresent()) {
            TipoVehiculoModel tvehiculoEncontrada = tvehiculoOptional.get();
            tvehiculoEditar.setIdTipoVehiculo(tvehiculoEncontrada.getIdTipoVehiculo());

            tvehiculoRepository.save(tvehiculoEditar);

            return new ResponseEntity<>(tvehiculoEditar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<?> agregarTipoVehiculo(@RequestBody TipoVehiculoModel nuevaTvehiculo) {

        nuevaTvehiculo = tvehiculoRepository.save(nuevaTvehiculo);

        Optional<TipoVehiculoModel> tvehiculoOptional = tvehiculoRepository.findById(nuevaTvehiculo.getIdTipoVehiculo());

        if (tvehiculoOptional.isPresent()) {
            TipoVehiculoModel tvehiculoEncontrada = tvehiculoOptional.get();
            return new ResponseEntity<>(tvehiculoEncontrada, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);

        }

    }
    
    @DeleteMapping("/{id}")
     public ResponseEntity<?> delete(@PathVariable String id) {

        Optional<TipoVehiculoModel> tvehiculoOptional = tvehiculoRepository.findById(Integer.parseInt(id));

        if (tvehiculoOptional.isPresent()) {
            
            TipoVehiculoModel tvehiculoEncontrada = tvehiculoOptional.get();
            tvehiculoRepository.deleteById(tvehiculoEncontrada.getIdTipoVehiculo());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

        
    }
    
}