/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.DevolucionModel;
import inacap.webcomponent.rentacar.repository.DevolucionRepository;
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
@RequestMapping("/Devolucion")
public class DevolucionController {

    @Autowired
    private DevolucionRepository devolucionRepository;

    @GetMapping()
    public Iterable<DevolucionModel> list() {
        return devolucionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DevolucionModel> muestraUnaDevolcion(@PathVariable String id) {
        Optional<DevolucionModel> devolucionOptional = devolucionRepository.findById(Integer.parseInt(id));

        if (devolucionOptional.isPresent()) {
            DevolucionModel devolucionEncontrada = devolucionOptional.get();
            return new ResponseEntity<>(devolucionEncontrada, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DevolucionModel> editaDevolucion(@PathVariable String id, @RequestBody DevolucionModel devolucionEditar) {

        Optional<DevolucionModel> devolucionOptional = devolucionRepository.findById(Integer.parseInt(id));

        if (devolucionOptional.isPresent()) {
            DevolucionModel devolucionEncontrada = devolucionOptional.get();
            devolucionEditar.setIdDevolucion(devolucionEncontrada.getIdDevolucion());

            devolucionRepository.save(devolucionEditar);

            return new ResponseEntity<>(devolucionEditar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> agregarDevolucion(@RequestBody DevolucionModel nuevaDevolucion) {

        nuevaDevolucion = devolucionRepository.save(nuevaDevolucion);

        Optional<DevolucionModel> devolucionOptional = devolucionRepository.findById(nuevaDevolucion.getIdDevolucion());

        if (devolucionOptional.isPresent()) {
            DevolucionModel devolucionEncontrada = devolucionOptional.get();
            return new ResponseEntity<>(devolucionEncontrada, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);

        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {

          Optional<DevolucionModel> devolucionOptional = devolucionRepository.findById(Integer.parseInt(id));

        if (devolucionOptional.isPresent()) {
            
            DevolucionModel devolucionEncontrada = devolucionOptional.get();
            devolucionRepository.deleteById(devolucionEncontrada.getIdDevolucion());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }
}
