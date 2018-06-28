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
 * @author Alexis
 */
@Entity
@Table(name="tipo_vehiculo")

public class TipoVehiculoModel {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
   
     private int idTipoVehiculo;
    private String nombreTipoVehiculo;
    private String detalleTipoVehiculo;
    
    

    public int getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(int idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public String getNombreTipoVehiculo() {
        return nombreTipoVehiculo;
    }

    public void setNombreTipoVehiculo(String nombreTipoVehiculo) {
        this.nombreTipoVehiculo = nombreTipoVehiculo;
    }

    public String getDetalleTipoVehiculo() {
        return detalleTipoVehiculo;
    }

    public void setDetalleTipoVehiculo(String detalleTipoVehiculo) {
        this.detalleTipoVehiculo = detalleTipoVehiculo;
    }

    public TipoVehiculoModel() {
    }

    public TipoVehiculoModel(String nombreTipoVehiculo, String detalleTipoVehiculo) {
        this.nombreTipoVehiculo = nombreTipoVehiculo;
        this.detalleTipoVehiculo = detalleTipoVehiculo;
    }

    private TipoVehiculoModel(int idTipoVehiculo, String nombreTipoVehiculo, String detalleTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
        this.nombreTipoVehiculo = nombreTipoVehiculo;
        this.detalleTipoVehiculo = detalleTipoVehiculo;
    }
    
    
      
    
    
    
    
    
}
