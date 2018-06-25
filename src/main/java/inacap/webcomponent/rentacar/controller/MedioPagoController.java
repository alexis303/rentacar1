/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.MedioPagoModel;
import inacap.webcomponent.rentacar.model.TipoVehiculoModel;
import inacap.webcomponent.rentacar.repository.MedioPagoRepository;
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

@RestController
@RequestMapping("/urlMedioPago")
public class MedioPagoController {
    
      @Autowired
      private MedioPagoRepository mpagoRepository;
    
      @GetMapping()
    public Iterable<MedioPagoModel> listarTodos() {
        
        return mpagoRepository.findAll();
        
    }

    
   @GetMapping("/{id}")
    public ResponseEntity<MedioPagoModel> muestraUnMedioPago(@PathVariable String id) {

        Optional<MedioPagoModel> mpagoOptional = mpagoRepository.findById(Integer.parseInt(id));

        if (mpagoOptional.isPresent()) {
            MedioPagoModel mpagoEncontrada = mpagoOptional.get();
            return new ResponseEntity<>(mpagoEncontrada, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
    
    @PutMapping("/{id}")
    public ResponseEntity<MedioPagoModel> editaMedioPago(@PathVariable String id, @RequestBody MedioPagoModel mpagoEditar) {

        Optional<MedioPagoModel> mpagoOptional = mpagoRepository.findById(Integer.parseInt(id));

        if (mpagoOptional.isPresent()) {
            MedioPagoModel mpagoEncontrada = mpagoOptional.get();
            mpagoEditar.setIdMedioPago(mpagoEncontrada.getIdMedioPago());

            mpagoRepository.save(mpagoEditar);

            return new ResponseEntity<>(mpagoEditar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<?> agregarMedioPago(@RequestBody MedioPagoModel nuevaMpago) {

        nuevaMpago = mpagoRepository.save(nuevaMpago);

        Optional<MedioPagoModel> mpagoOptional = mpagoRepository.findById(nuevaMpago.getIdMedioPago());

        if (mpagoOptional.isPresent()) {
            MedioPagoModel mpagoEncontrada = mpagoOptional.get();
            return new ResponseEntity<>(mpagoEncontrada, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);

        }

    }
    
    @DeleteMapping("/{id}")
     public ResponseEntity<?> delete(@PathVariable String id) {

        Optional<MedioPagoModel> mpagoOptional = mpagoRepository.findById(Integer.parseInt(id));

        if (mpagoOptional.isPresent()) {
            
            MedioPagoModel mpagoEncontrada = mpagoOptional.get();
            mpagoRepository.deleteById(mpagoEncontrada.getIdMedioPago());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

        
    }
    
    
}
