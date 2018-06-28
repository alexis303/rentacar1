/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.CarroceriaModel;
import inacap.webcomponent.rentacar.repository.CarroceriaRepository;
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
@RequestMapping("/Carroceria")
public class CarroceriaController {

    @Autowired
    private CarroceriaRepository carroceriaRepository;

    @GetMapping()
    public Iterable<CarroceriaModel> list() {
        return carroceriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroceriaModel> muestraUnaCarroceria(@PathVariable String id) {

        Optional<CarroceriaModel> carroceriaOptional = carroceriaRepository.findById(Integer.parseInt(id));

        if (carroceriaOptional.isPresent()) {
            CarroceriaModel carroceriaEncontrada = carroceriaOptional.get();
            return new ResponseEntity<>(carroceriaEncontrada, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarroceriaModel> editaCarroceria(@PathVariable String id, @RequestBody CarroceriaModel carroceriaEditar) {
        Optional<CarroceriaModel> carroceriaOptional = carroceriaRepository.findById(Integer.parseInt(id));

        if (carroceriaOptional.isPresent()) {
            CarroceriaModel carroceriaEncontrada = carroceriaOptional.get();
            carroceriaEditar.setIdCarroceria(carroceriaEncontrada.getIdCarroceria());

            carroceriaRepository.save(carroceriaEditar);

            return new ResponseEntity<>(carroceriaEditar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> agregarCarroceria(@RequestBody CarroceriaModel nuevaCarroceria) {

        nuevaCarroceria = carroceriaRepository.save(nuevaCarroceria);

        Optional<CarroceriaModel> carroceriaOptional = carroceriaRepository.findById(nuevaCarroceria.getIdCarroceria());

        if (carroceriaOptional.isPresent()) {
            CarroceriaModel carroceriaEncontrada = carroceriaOptional.get();
            return new ResponseEntity<>(carroceriaEncontrada, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);

        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {

        Optional<CarroceriaModel> CarroceriaOptional = carroceriaRepository.findById(Integer.parseInt(id));

        if (CarroceriaOptional.isPresent()) {

            CarroceriaModel carroceriaEncontrada = CarroceriaOptional.get();
            carroceriaRepository.deleteById(carroceriaEncontrada.getIdCarroceria());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }

}


