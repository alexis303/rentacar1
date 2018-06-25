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

@Entity
@Table(name = "Carroceria")
public class CarroceriaModel {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)

    private int idCarroceria;
    private String nombreCarroceria;
    private String detalleCarroceria;

    

    public int getIdCarroceria() {
        return idCarroceria;
    }

    public void setIdCarroceria(int idCarroceria) {
        this.idCarroceria = idCarroceria;
    }

    public String getNombreCarroceria() {
        return nombreCarroceria;
    }

    public void setNombreCarroceria(String nombreCarroceria) {
        this.nombreCarroceria = nombreCarroceria;
    }

    public String getDetalleCarroceria() {
        return detalleCarroceria;
    }

    public void setDetalleCarroceria(String detalleCarroceria) {
        this.detalleCarroceria = detalleCarroceria;
    }

    public CarroceriaModel() {
    }

    public CarroceriaModel(String nombreCarroceria, String detalleCarroceria) {
        this.nombreCarroceria = nombreCarroceria;
        this.detalleCarroceria = detalleCarroceria;
    }

    private CarroceriaModel(int idCarroceria, String nombreCarroceria, String detalleCarroceria) {
        this.idCarroceria = idCarroceria;
        this.nombreCarroceria = nombreCarroceria;
        this.detalleCarroceria = detalleCarroceria;
    }

    

}
