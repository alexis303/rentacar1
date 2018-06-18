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
@Table(name="Region")
public class RegionModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idRegion;
    private String nombreRegion;
    private String detalleRegion;

    

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public String getNombreRegion() {
        return nombreRegion;
    }

    public void setNombreRegion(String nombreRegion) {
        this.nombreRegion = nombreRegion;
    }

    public String getDetalleRegion() {
        return detalleRegion;
    }

    public void setDetalleRegion(String detalleRegion) {
        this.detalleRegion = detalleRegion;
    }

    public RegionModel() {
    }

    public RegionModel(String nombreRegion, String detalleRegion) {
        this.nombreRegion = nombreRegion;
        this.detalleRegion = detalleRegion;
    }

    private RegionModel(int idRegion, String nombreRegion, String detalleRegion) {
        this.idRegion = idRegion;
        this.nombreRegion = nombreRegion;
        this.detalleRegion = detalleRegion;
    }
      
   
    
    
    

}
