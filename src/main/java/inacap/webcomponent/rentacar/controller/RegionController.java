/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.RegionModel;
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
import inacap.webcomponent.rentacar.repository.RegionRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author 19798398-1
 */
@RestController
@RequestMapping("/Region")
public class RegionController {

    @Autowired
    private RegionRepository regionRepository;

    @GetMapping()
    public Iterable<RegionModel> listarTodos() {

        return regionRepository.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<RegionModel> muestraUnaRegion(@PathVariable String id) {

        Optional<RegionModel> regionOptional = regionRepository.findById(Integer.parseInt(id));

        if (regionOptional.isPresent()) {
            RegionModel regionEncontrada = regionOptional.get();
            return new ResponseEntity<>(regionEncontrada, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<RegionModel> editaRegion(@PathVariable String id, @RequestBody RegionModel regionEditar) {

        Optional<RegionModel> regionOptional = regionRepository.findById(Integer.parseInt(id));

        if (regionOptional.isPresent()) {
            RegionModel regionEncontrada = regionOptional.get();
            regionEditar.setIdRegion(regionEncontrada.getIdRegion());

            regionRepository.save(regionEditar);

            return new ResponseEntity<>(regionEditar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<?> agregarRegion(@RequestBody RegionModel nuevaRegion) {

        nuevaRegion = regionRepository.save(nuevaRegion);

        Optional<RegionModel> regionOptional = regionRepository.findById(nuevaRegion.getIdRegion());

        if (regionOptional.isPresent()) {
            RegionModel regionEncontrada = regionOptional.get();
            return new ResponseEntity<>(regionEncontrada, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);

        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {

        Optional<RegionModel> regioOptional = regionRepository.findById(Integer.parseInt(id));

        if (regioOptional.isPresent()) {
            
            RegionModel regionEncontrada = regioOptional.get();
            regionRepository.deleteById(regionEncontrada.getIdRegion());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }
}
