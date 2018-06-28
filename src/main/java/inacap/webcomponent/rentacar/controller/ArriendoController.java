/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.ArriendoModel;
import inacap.webcomponent.rentacar.repository.ArriendoRepository;
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
 * @author Alexis
 */
@RestController
@RequestMapping("/Arriendo")
public class ArriendoController {

    @Autowired
    private ArriendoRepository arriendoRepository;

    @GetMapping()
    public Iterable<ArriendoModel> list() {
        return arriendoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArriendoModel> muestraUnArriendo(@PathVariable String id) {

        Optional<ArriendoModel> arriendoOptional = arriendoRepository.findById(Integer.parseInt(id));

        if (arriendoOptional.isPresent()) {
            ArriendoModel arriendoEncontrada = arriendoOptional.get();
            return new ResponseEntity<>(arriendoEncontrada, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArriendoModel> editaArriendo(@PathVariable String id, @RequestBody ArriendoModel arriendoEditar) {
        Optional<ArriendoModel> arriendoOptional = arriendoRepository.findById(Integer.parseInt(id));

        if (arriendoOptional.isPresent()) {
            ArriendoModel arriendoEncontrada = arriendoOptional.get();
            arriendoEditar.setIdArriendo(arriendoEncontrada.getIdArriendo());

            arriendoRepository.save(arriendoEditar);

            return new ResponseEntity<>(arriendoEditar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> agregarArriendo(@RequestBody ArriendoModel nuevoArriendo) {
        nuevoArriendo = arriendoRepository.save(nuevoArriendo);

        Optional<ArriendoModel> arriendoOptional = arriendoRepository.findById(nuevoArriendo.getIdArriendo());

        if (arriendoOptional.isPresent()) {
            ArriendoModel arriendoEncontrada = arriendoOptional.get();
            return new ResponseEntity<>(arriendoEncontrada, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);

        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {

        Optional<ArriendoModel> arriendoOptional = arriendoRepository.findById(Integer.parseInt(id));

        if (arriendoOptional.isPresent()) {
            
            ArriendoModel arriendoEncontrada = arriendoOptional.get();
            arriendoRepository.deleteById(arriendoEncontrada.getIdArriendo());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }

}
