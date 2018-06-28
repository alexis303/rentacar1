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
@Table(name = "marca")
public class MarcaModel {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int idMarca;
    private String nombreMarca;
    private String detalleMarca;
  

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getDetalleMarca() {
        return detalleMarca;
    }

    public void setDetalleMarca(String detalleMarca) {
        this.detalleMarca = detalleMarca;
    }

    public MarcaModel() {
    }

    public MarcaModel(String nombreMarca, String detalleMarca) {
        this.nombreMarca = nombreMarca;
        this.detalleMarca = detalleMarca;
    }

    private MarcaModel(int idMarca, String nombreMarca, String detalleMarca) {
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
        this.detalleMarca = detalleMarca;
    }
    
    
}
