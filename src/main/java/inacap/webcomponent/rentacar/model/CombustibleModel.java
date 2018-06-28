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
@Table(name = "combustible")
public class CombustibleModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    
    private int idCombustible;
    private String tipoCombustible;
    private String detalleCombustible;
    
    
   

    public int getIdCombustible() {
        return idCombustible;
    }

    public void setIdCombustible(int idCombustible) {
        this.idCombustible = idCombustible;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getDetalleCombustible() {
        return detalleCombustible;
    }

    public void setDetalleCombustible(String detalleCombustible) {
        this.detalleCombustible = detalleCombustible;
    }

    public CombustibleModel() {
    }

    public CombustibleModel(String tipoCombustible, String detalleCombustible) {
        this.tipoCombustible = tipoCombustible;
        this.detalleCombustible = detalleCombustible;
    }

    private CombustibleModel(int idCombustible, String tipoCombustible, String detalleCombustible) {
        this.idCombustible = idCombustible;
        this.tipoCombustible = tipoCombustible;
        this.detalleCombustible = detalleCombustible;
    }

    
    
        
    
    
}
