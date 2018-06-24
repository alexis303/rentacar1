/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.ModeloModel;
import inacap.webcomponent.rentacar.repository.ModeloRepository;
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
@RequestMapping("/urlModelo")
public class ModeloController {
    
    @Autowired
    private ModeloRepository modeloRepository;
    
     @GetMapping()
    public Iterable<ModeloModel> listarTodos() {
        
        return modeloRepository.findAll();
        
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<ModeloModel> muestraUnModelo(@PathVariable String id) {

        Optional<ModeloModel> ModeloOptional = modeloRepository.findById(Integer.parseInt(id));

        if (ModeloOptional.isPresent()) {
            ModeloModel modeloEncontrada = ModeloOptional.get();
            return new ResponseEntity<>(modeloEncontrada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    
    @PutMapping("/{id}")
     public ResponseEntity<ModeloModel> editaModelo(@PathVariable String id, @RequestBody ModeloModel modeloEditar) {

        Optional<ModeloModel>modeloOptional = modeloRepository.findById(Integer.parseInt(id));

        if (modeloOptional.isPresent()) {
            ModeloModel modeloEncontrada = modeloOptional.get();
            modeloEditar.setIdModelo(modeloEncontrada.getIdModelo());
            
            modeloRepository.save(modeloEditar);
            

            return new ResponseEntity<>(modeloEditar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    
   
  @PostMapping
    public ResponseEntity<?> agregarModelo(@RequestBody ModeloModel nuevoModelo) {

       nuevoModelo = modeloRepository.save(nuevoModelo);

        Optional<ModeloModel> ModeloOptional = modeloRepository.findById(nuevoModelo.getIdModelo());

        if (ModeloOptional.isPresent()) {
            ModeloModel ModeloEncontrada = ModeloOptional.get();
            return new ResponseEntity<>(ModeloEncontrada, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);

        }

    }
    
    @DeleteMapping("/{id}")
     public ResponseEntity<?> delete(@PathVariable String id) {

        Optional<ModeloModel> modeloOptional = modeloRepository.findById(Integer.parseInt(id));

        if (modeloOptional.isPresent()) {
            
            ModeloModel ModeloEncontrada = modeloOptional.get();
            modeloRepository.deleteById(ModeloEncontrada.getIdModelo());

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }
}
        
        
   
