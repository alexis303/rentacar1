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
@Table(name="Modelo")
public class ModeloModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int idModelo;
    private String nombreModelo;
    private String detalleModelo;
    private MarcaModel marca;
    
    

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public String getDetalleModelo() {
        return detalleModelo;
    }

    public void setDetalleModelo(String detalleModelo) {
        this.detalleModelo = detalleModelo;
    }

    public MarcaModel getMarca() {
        return marca;
    }

    public void setMarca(MarcaModel marca) {
        this.marca = marca;
    }

    public ModeloModel() {
    }

    public ModeloModel(String nombreModelo, String detalleModelo, MarcaModel marca) {
        this.nombreModelo = nombreModelo;
        this.detalleModelo = detalleModelo;
        this.marca = marca;
    }

    private ModeloModel(int idModelo, String nombreModelo, String detalleModelo, MarcaModel marca) {
        this.idModelo = idModelo;
        this.nombreModelo = nombreModelo;
        this.detalleModelo = detalleModelo;
        this.marca = marca;
    }
    
      
   
}
