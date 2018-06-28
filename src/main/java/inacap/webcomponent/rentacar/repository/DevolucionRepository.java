/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.repository;

import inacap.webcomponent.rentacar.model.DevolucionModel;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Alexis
 */
public interface DevolucionRepository extends CrudRepository<DevolucionModel, Integer> {
    
}
