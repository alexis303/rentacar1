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
public class TransmisionModel {

    private int idTransmision;
    private String nombreTransmision;
    private String detalleTransmision;

    public static ArrayList<TransmisionModel> transmision = new ArrayList<>();

    public int getIdTransmision() {
        return idTransmision;
    }

    public void setIdTransmision(int idTransmision) {
        this.idTransmision = idTransmision;
    }

    public String getNombreTransmision() {
        return nombreTransmision;
    }

    public void setNombreTransmision(String nombreTransmision) {
        this.nombreTransmision = nombreTransmision;
    }

    public String getDetalleTransmision() {
        return detalleTransmision;
    }

    public void setDetalleTransmision(String detalleTransmision) {
        this.detalleTransmision = detalleTransmision;
    }

   
    
    
    public TransmisionModel() {
    }

    public TransmisionModel(String nombreTransmision, String detalleTransmision) {
        this.nombreTransmision = nombreTransmision;
        this.detalleTransmision = detalleTransmision;
    }

    private TransmisionModel(int idTransmision, String nombreTransmision, String detalleTransmision) {
        this.idTransmision = idTransmision;
        this.nombreTransmision = nombreTransmision;
        this.detalleTransmision = detalleTransmision;
    }
  
    public boolean nuevaTransmision(TransmisionModel nuevaTransmision){
    
        int id = 0;
        
        if (!transmision.isEmpty()) {
            
            for (TransmisionModel transmisiones : transmision) {
                if (transmisiones.getIdTransmision()> id) {
                    id = transmisiones.getIdTransmision();
                }
            }
            
        }
        
        id++;
        
        transmision.add(new TransmisionModel(id, nuevaTransmision.getNombreTransmision(), nuevaTransmision.getDetalleTransmision()));
         
        return true;
    }
    
    public TransmisionModel buscatransmision(int idTransmisionBuscada){
    
        TransmisionModel transmisionEncontrada = null;
        
        if(!transmision.isEmpty()){
            for (TransmisionModel transmisiones : transmision) {
                if (transmisiones.getIdTransmision()== idTransmisionBuscada) {
                    transmisionEncontrada = transmisiones;
                }
            }
        }
        
        return transmisionEncontrada;
        
    }
    
    public TransmisionModel editarTransmision(int idTransmision, TransmisionModel transmisionEditar){
    
        TransmisionModel transmisionEditada = null;
        
        if(!transmision.isEmpty()){
            for (TransmisionModel transmisiones : transmision) {
                if (transmisiones.getIdTransmision()== idTransmision) {
                    transmisiones.setNombreTransmision(transmisionEditar.getNombreTransmision());
                    transmisiones.setDetalleTransmision(transmisionEditar.getDetalleTransmision());
                    
                    transmisionEditada = transmisiones;
                }
            }
        }
        
        return transmisionEditada;
        
    }
    
    public boolean eliminarTransmision(int id){
        TransmisionModel transmisionEliminada = null;
        
        if(!transmision.isEmpty()){
            for (TransmisionModel transmisiones : transmision) {
                if (transmisiones.getIdTransmision()== idTransmision) {
                   transmisionEliminada = transmisiones;
                }
            }
        }
        
        transmision.remove(transmisionEliminada);
        
        
        return true;
    }
    
    
    
}
