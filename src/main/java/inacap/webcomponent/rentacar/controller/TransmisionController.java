/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.TransmisionModel;
import inacap.webcomponent.rentacar.repository.TransmisionRepository;
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
@RequestMapping("/urlTransmision")
public class TransmisionController {
    
    @Autowired
    private TransmisionRepository transmisionRepository;


    @GetMapping()
   public Iterable<TransmisionModel> listarTodos() {

        return transmisionRepository.findAll();

    }
    @GetMapping("/{id}")
   public ResponseEntity<TransmisionModel> muestraUnaTransmision(@PathVariable String id) {

        Optional<TransmisionModel> transmisionOptional = transmisionRepository.findById(Integer.parseInt(id));

        if (transmisionOptional.isPresent()) {
            TransmisionModel transmisionEncontrada = transmisionOptional.get();
            return new ResponseEntity<>(transmisionEncontrada, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<TransmisionModel> editaTransmision(@PathVariable String id, @RequestBody TransmisionModel transmisionEditar) {

        Optional<TransmisionModel> transmisionOptional = transmisionRepository.findById(Integer.parseInt(id));

        if (transmisionOptional.isPresent()) {
            TransmisionModel transmisionEncontrada = transmisionOptional.get();
            transmisionEditar.setIdTransmision(transmisionEncontrada.getIdTransmision());

            transmisionRepository.save(transmisionEditar);

            return new ResponseEntity<>(transmisionEditar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }

    @PostMapping
    public ResponseEntity<?> agregarTransmision(@RequestBody TransmisionModel nuevaTransmision) {

       nuevaTransmision = transmisionRepository.save(nuevaTransmision);

        Optional<TransmisionModel> transmisionOptional = transmisionRepository.findById(nuevaTransmision.getIdTransmision());

        if (transmisionOptional.isPresent()) {
            TransmisionModel transmisionEncontrada = transmisionOptional.get();
            return new ResponseEntity<>(transmisionEncontrada, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);

        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {

       Optional<TransmisionModel> transmisionOptional = transmisionRepository.findById(Integer.parseInt(id));

        if (transmisionOptional.isPresent()) {
            
            TransmisionModel transmisionEncontrada = transmisionOptional.get();
            transmisionRepository.deleteById(transmisionEncontrada.getIdTransmision());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }

}
