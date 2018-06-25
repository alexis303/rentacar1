/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.TipoPersonaModel;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/urlTipoPersona")
public class TipoPersonaController {
    
    @Autowired
    private TipoPersonaRepository tpersonaRepository;
    
    @GetMapping()
    public Iterable<TipoPersonaModel> listarTodos() {
        
        return tpersonaRepository.findAll;
        
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<TipoPersonaModel> muestraUnTipoPersona(@PathVariable String id) {

        Optional<TipoPersonaModel> tpersonaOptional = tpersonaRepository.findById(Integer.parseInt(id));

        if (tpersonaOptional.isPresent()) {
            TipoPersonaModel tpersonaEncontrada = tpersonaOptional.get();
            return new ResponseEntity<>(tpersonaEncontrada, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TipoPersonaModel> editaTipoPersona(@PathVariable String id, @RequestBody TipoPersonaModel tpersonaEditar) {

        Optional<TipoPersonaModel> tpersonaOptional = tpersonaRepository.findById(Integer.parseInt(id));

        if (tpersonaOptional.isPresent()) {
            TipoPersonaModel tpersonaEncontrada = tpersonaOptional.get();
            tpersonaEditar.setIdTipoPersona(tpersonaEncontrada.getIdTipoPersona());

            tpersonaRepository.save(tpersonaEditar);

            return new ResponseEntity<>(tpersonaEditar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<?> agregarTipoPersona(@RequestBody TipoPersonaModel nuevaTpersona) {

        nuevaTpersona = tpersonaRepository.save(nuevaTpersona);

        Optional<TipoPersonaModel> tpersonaOptional = tpersonaRepository.findById(nuevaTpersona.getIdTipoPersona());

        if (tpersonaOptional.isPresent()) {
            TipoPersonaModel tpersonaEncontrada = tpersonaOptional.get();
            return new ResponseEntity<>(tpersonaEncontrada, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);

        }

    }
    
    @DeleteMapping("/{id}")
     public ResponseEntity<?> delete(@PathVariable String id) {

        Optional<TipoPersonaModel> tpersonaOptional = tpersonaRepository.findById(Integer.parseInt(id));

        if (tpersonaOptional.isPresent()) {
            
            TipoPersonaModel tpersonaEncontrada = tpersonaOptional.get();
            tpersonaRepository.deleteById(tpersonaEncontrada.getIdTipoPersona());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

        
    }
    
}
