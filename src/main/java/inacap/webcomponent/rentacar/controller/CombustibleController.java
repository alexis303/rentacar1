/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.CombustibleModel;
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
@RequestMapping("/urlCombustible")
public class CombustibleController {
    
   @GetMapping()
    public List<CombustibleModel> list() {
        return CombustibleModel.combustible;
    }

    @GetMapping("/{id}")
    public CombustibleModel muestraUnCombustible(@PathVariable String id) {
        CombustibleModel combustibles = new CombustibleModel();

        return combustibles.buscaCombustible(Integer.parseInt(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CombustibleModel> editaCombustible(@PathVariable String id, @RequestBody CombustibleModel combustibleEditar) {

        CombustibleModel combustibles = new CombustibleModel();

        return new ResponseEntity<>(combustibles.editarCombustible(Integer.parseInt(id), combustibleEditar), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> agregarArriendo(@RequestBody CombustibleModel nuevoCombustible) {

        CombustibleModel combustibles = new CombustibleModel();

        if (combustibles.nuevoCombustible(nuevoCombustible)) {

            return new ResponseEntity<>(HttpStatus.CREATED);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {

        CombustibleModel combustibles = new CombustibleModel();

        if (combustibles.eliminarCombustible(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }
    
}
