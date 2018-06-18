/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.CiudadModel;
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

/**
 *
 * @author Alexis
 */
@RestController
@RequestMapping("/urlCiudad")
public class CiudadController {
    
    @GetMapping()
    public List<CiudadModel> list() {
        return CiudadModel.ciudad;
    }

    @GetMapping("/{id}")
    public CiudadModel muestraUnaCiudad(@PathVariable String id) {
        CiudadModel ciudades = new CiudadModel();

        return ciudades.buscaCiudad(Integer.parseInt(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CiudadModel> editaArriendo(@PathVariable String id, @RequestBody CiudadModel ciudadEditar) {

        CiudadModel ciudades = new CiudadModel();

        return new ResponseEntity<>(ciudades.editarCiudad(Integer.parseInt(id), ciudadEditar), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> agregarArriendo(@RequestBody CiudadModel nuevaCiudad) {

        CiudadModel ciudades = new CiudadModel();

        if (ciudades.nuevaCiudad(nuevaCiudad)) {

            return new ResponseEntity<>(HttpStatus.CREATED);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {

        CiudadModel ciudades = new CiudadModel();

        if (ciudades.eliminarCiudad(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }
    
}
