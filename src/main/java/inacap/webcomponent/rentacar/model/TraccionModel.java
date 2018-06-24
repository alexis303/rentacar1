/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.model;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author 19798398-1
 */

@Entity
@Table(name ="Traccion")
public class TraccionModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int idTraccion;
    private String nombreTraccion;
    private String detalleTraccion;
    
    

    public int getIdTraccion() {
        return idTraccion;
    }

    public void setIdTraccion(int idTraccion) {
        this.idTraccion = idTraccion;
    }

    public String getNombreTraccion() {
        return nombreTraccion;
    }

    public void setNombreTraccion(String nombreTraccion) {
        this.nombreTraccion = nombreTraccion;
    }

    public String getDetalleTraccion() {
        return detalleTraccion;
    }

    public void setDetalleTraccion(String detalleTraccion) {
        this.detalleTraccion = detalleTraccion;
    }

    public TraccionModel() {
    }

    public TraccionModel(String nombreTraccion, String detalleTraccion) {
        this.nombreTraccion = nombreTraccion;
        this.detalleTraccion = detalleTraccion;
    }

    private TraccionModel(int idTraccion, String nombreTraccion, String detalleTraccion) {
        this.idTraccion = idTraccion;
        this.nombreTraccion = nombreTraccion;
        this.detalleTraccion = detalleTraccion;
    }
    
      
   
}
