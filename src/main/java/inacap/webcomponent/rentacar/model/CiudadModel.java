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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Alexis
 */
@Entity
@Table(name = "ciudad")
public class CiudadModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idCiudad;
    private String nombreCiudad;
    private String detalleCiudad;
    
    @ManyToOne
    @JoinColumn(name = "id_region")
    private RegionModel region;

    

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getDetalleCiudad() {
        return detalleCiudad;
    }

    public void setDetalleCiudad(String detalleCiudad) {
        this.detalleCiudad = detalleCiudad;
    }

    public RegionModel getRegion() {
        return region;
    }

    public void setRegion(RegionModel region) {
        this.region = region;
    }

    public CiudadModel() {
    }

    public CiudadModel(String nombreCiudad, String detalleCiudad, RegionModel region) {
        this.nombreCiudad = nombreCiudad;
        this.detalleCiudad = detalleCiudad;
        this.region = region;
    }

    private CiudadModel(int idCiudad, String nombreCiudad, String detalleCiudad, RegionModel region) {
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
        this.detalleCiudad = detalleCiudad;
        this.region = region;
    }

    

}
