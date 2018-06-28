/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.VersionModel;
import inacap.webcomponent.rentacar.repository.VersionRepository;
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
@RequestMapping("/Version")
public class VersionController {

    @Autowired
    private VersionRepository versionRepository;

    @GetMapping()
    public Iterable<VersionModel> listarTodos() {

        return versionRepository.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<VersionModel> muestraUnaVersion(@PathVariable String id) {
        Optional<VersionModel> versionOptional = versionRepository.findById(Integer.parseInt(id));

        if (versionOptional.isPresent()) {
            VersionModel versionEncontrada = versionOptional.get();
            return new ResponseEntity<>(versionEncontrada, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<VersionModel> editaVersion(@PathVariable String id, @RequestBody VersionModel versionEditar) {
        Optional<VersionModel> versionOptional = versionRepository.findById(Integer.parseInt(id));

        if (versionOptional.isPresent()) {
            VersionModel versionEncontrada = versionOptional.get();
            versionEditar.setIdVersion(versionEncontrada.getIdVersion());

            versionRepository.save(versionEditar);

            return new ResponseEntity<>(versionEditar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> agregarVersion(@RequestBody VersionModel nuevaVersion) {

       nuevaVersion = versionRepository.save(nuevaVersion);

        Optional<VersionModel> versionOptional = versionRepository.findById(nuevaVersion.getIdVersion());

        if (versionOptional.isPresent()) {
            VersionModel versionEncontrada = versionOptional.get();
            return new ResponseEntity<>(versionEncontrada, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);

        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {

        Optional<VersionModel> versionOptional = versionRepository.findById(Integer.parseInt(id));

        if (versionOptional.isPresent()) {
            
            VersionModel versionEncontrada = versionOptional.get();
            versionRepository.deleteById(versionEncontrada.getIdVersion());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }


    }

}
