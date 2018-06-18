/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.model;

import java.util.ArrayList;

/**
 *
 * @author 19798398-1
 */
public class CombustibleModel {
    
    
    private int idCombustible;
    private String tipoCombustible;
    private String detalleCombustible;
    
    
    public static ArrayList<CombustibleModel> combustible = new ArrayList<>();

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

     public boolean nuevoCombustible(CombustibleModel nuevoCombustible){
    
        int id = 0;
        
        if (!combustible.isEmpty()) {
            
            for (CombustibleModel combustibles : combustible) {
                if (combustibles.getIdCombustible()> id) {
                    id = combustibles.getIdCombustible();
                }
            }
            
        }
        
        id++;
        
        combustible.add(new CombustibleModel(id, nuevoCombustible.getTipoCombustible(), nuevoCombustible.getDetalleCombustible()));
         
        return true;
    }
    
    public CombustibleModel buscaCombustible(int idCombustibleBuscado){
    
        CombustibleModel combustibleEncontrado = null;
        
        if(!combustible.isEmpty()){
            for (CombustibleModel combustibles : combustible) {
                if (combustibles.getIdCombustible()== idCombustibleBuscado) {
                    combustibleEncontrado = combustibles;
                }
            }
        }
        
        return combustibleEncontrado;
        
    }
    
    public CombustibleModel editarCombustible(int idCombustible, CombustibleModel combustibleEditar){
    
        CombustibleModel combustibleEditado = null;
        
        if(!combustible.isEmpty()){
            for (CombustibleModel combustibles : combustible) {
                if (combustibles.getIdCombustible()== idCombustible) {
                    combustibles.setTipoCombustible(combustibleEditar.getTipoCombustible());
                    combustibles.setDetalleCombustible(combustibleEditar.getDetalleCombustible());
                    
                    combustibleEditado = combustibles;
                }
            }
        }
        
        return combustibleEditado;
        
    }
    
    public boolean eliminarCombustible(int id){
        CombustibleModel combustibleEliminado = null;
        
        if(!combustible.isEmpty()){
            for (CombustibleModel combustibles : combustible) {
                if (combustibles.getIdCombustible()== idCombustible) {
                   combustibleEliminado = combustibles;
                }
            }
        }
        
        combustible.remove(combustibleEliminado);
        
        
        return true;
    }
    
        
    
    
}
