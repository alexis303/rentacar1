/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.MarcaModel;
import inacap.webcomponent.rentacar.repository.MarcaRepository;
import inacap.webcomponent.rentacar.repository.RegionRepository;
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
@RequestMapping("/Marca")
public class MarcaController {
    
    @Autowired
    private MarcaRepository marcaRepository;
    
    @GetMapping()
      public Iterable<MarcaModel> listarTodos() {

        return marcaRepository.findAll();

    }
    
    
     @GetMapping("/{id}")
    public ResponseEntity<MarcaModel> muestraUnaMarca(@PathVariable String id) {
         Optional<MarcaModel> marcaOptional = marcaRepository.findById(Integer.parseInt(id));

        if (marcaOptional.isPresent()) {
            MarcaModel marcaEncontrada = marcaOptional.get();
            return new ResponseEntity<>(marcaEncontrada, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
    
   @PutMapping("/{id}")
    public ResponseEntity<MarcaModel> editaMarca(@PathVariable String id, @RequestBody MarcaModel marcaEditar) {

        Optional<MarcaModel> marcaOptional = marcaRepository.findById(Integer.parseInt(id));

        if (marcaOptional.isPresent()) {
           MarcaModel marcaEncontrada = marcaOptional.get();
           marcaEditar.setIdMarca(marcaEncontrada.getIdMarca());
           marcaRepository.save(marcaEditar);
           

            return new ResponseEntity<>(marcaEditar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
    
    @PostMapping
    public ResponseEntity<?> agregarMarca(@RequestBody MarcaModel nuevaMarca) {

        nuevaMarca = marcaRepository.save(nuevaMarca);

        Optional<MarcaModel> marcaOptional = marcaRepository.findById(nuevaMarca.getIdMarca());

        if (marcaOptional.isPresent()) {
            MarcaModel marcaEncontrada = marcaOptional.get();
            return new ResponseEntity<>(marcaEncontrada, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);

        }

    }

    
    @DeleteMapping("/{id}")
   public ResponseEntity<?> delete(@PathVariable String id) {

        Optional<MarcaModel> marcaOptional = marcaRepository.findById(Integer.parseInt(id));

        if (marcaOptional.isPresent()) {
            
            MarcaModel marcaEncontrada = marcaOptional.get();
            marcaRepository.deleteById(marcaEncontrada.getIdMarca());

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }
    
}
