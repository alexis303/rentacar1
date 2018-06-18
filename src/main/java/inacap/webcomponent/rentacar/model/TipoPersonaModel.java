/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.model;

import java.util.ArrayList;

/**
 *
 * @author Alexis
 */
public class TipoPersonaModel {
    
     private int idTipoPersona;
    private String nombreTipoPersona;
    private String detalleTipoPersona;
    
    public static ArrayList<TipoPersonaModel> tipoPersona = new ArrayList<>();

    public int getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(int idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public String getNombreTipoPersona() {
        return nombreTipoPersona;
    }

    public void setNombreTipoPersona(String nombreTipoPersona) {
        this.nombreTipoPersona = nombreTipoPersona;
    }

    public String getDetalleTipoPersona() {
        return detalleTipoPersona;
    }

    public void setDetalleTipoPersona(String detalleTipoPersona) {
        this.detalleTipoPersona = detalleTipoPersona;
    }

    public TipoPersonaModel() {
    }

    public TipoPersonaModel(String nombreTipoPersona, String detalleTipoPersona) {
        this.nombreTipoPersona = nombreTipoPersona;
        this.detalleTipoPersona = detalleTipoPersona;
    }

    private TipoPersonaModel(int idTipoPersona, String nombreTipoPersona, String detalleTipoPersona) {
        this.idTipoPersona = idTipoPersona;
        this.nombreTipoPersona = nombreTipoPersona;
        this.detalleTipoPersona = detalleTipoPersona;
    }
    
    
      
    public boolean nuevoTipoPersona(TipoPersonaModel nuevoTipoPersona){
    
        int id = 0;
        
        if (!tipoPersona.isEmpty()) {
            
            for (TipoPersonaModel tiposDePersonas : tipoPersona) {
                if (tiposDePersonas.getIdTipoPersona()> id) {
                    id = tiposDePersonas.getIdTipoPersona();
                }
            }
            
        }
        
        id++;
        
        tipoPersona.add(new TipoPersonaModel(id, nuevoTipoPersona.getNombreTipoPersona(), nuevoTipoPersona.getDetalleTipoPersona()));
         
        return true;
    }
    
    public TipoPersonaModel buscaTipoPersona(int idTipoPersonaBuscado){
    
        TipoPersonaModel tipoPersonaEncontrado = null;
        
        if(!tipoPersona.isEmpty()){
            for (TipoPersonaModel tiposDePersonas : tipoPersona) {
                if (tiposDePersonas.getIdTipoPersona()== idTipoPersonaBuscado) {
                    tipoPersonaEncontrado = tiposDePersonas;
                }
            }
        }
        
        return tipoPersonaEncontrado;
        
    }
    
    public TipoPersonaModel editarTipoPersona(int idTipoPersona, TipoPersonaModel tipoPersonaEditar){
    
        TipoPersonaModel tipoPersonaEditado = null;
        
        if(!tipoPersona.isEmpty()){
            for (TipoPersonaModel tiposDePersonas : tipoPersona) {
                if (tiposDePersonas.getIdTipoPersona()== idTipoPersona) {
                    tiposDePersonas.setNombreTipoPersona(tipoPersonaEditar.getNombreTipoPersona());
                    tiposDePersonas.setDetalleTipoPersona(tipoPersonaEditar.getDetalleTipoPersona());
                    
                    tipoPersonaEditado = tiposDePersonas;
                }
            }
        }
        
        return tipoPersonaEditado;
        
    }
    
    public boolean eliminarTipoPersona(int id){
        TipoPersonaModel tipoPersonaEliminado = null;
        
        if(!tipoPersona.isEmpty()){
            for (TipoPersonaModel tiposDePersonas : tipoPersona) {
                if (tiposDePersonas.getIdTipoPersona()== idTipoPersona) {
                   tipoPersonaEliminado = tiposDePersonas;
                }
            }
        }
        
        tipoPersona.remove(tipoPersonaEliminado);
        
        
        return true;
    }
    
    
    
}
