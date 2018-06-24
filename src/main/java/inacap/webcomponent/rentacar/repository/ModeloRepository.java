/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.repository;

import inacap.webcomponent.rentacar.model.ModeloModel;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ANDREA
 */
public interface ModeloRepository extends CrudRepository<ModeloModel, Integer> {

    public List<ModeloModel> findById();
    
}
