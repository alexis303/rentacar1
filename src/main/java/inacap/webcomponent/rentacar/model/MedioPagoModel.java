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
public class MedioPagoModel {
    
     private int idMedioPago;
    private String nombreMedioPago;
    private String detalleMedioPago;
    
    public static ArrayList<MedioPagoModel> medioPago = new ArrayList<>();

    public int getIdMedioPago() {
        return idMedioPago;
    }

    public void setIdMedioPago(int idMedioPago) {
        this.idMedioPago = idMedioPago;
    }

    public String getNombreMedioPago() {
        return nombreMedioPago;
    }

    public void setNombreMedioPago(String nombreMedioPago) {
        this.nombreMedioPago = nombreMedioPago;
    }

    public String getDetalleMedioPago() {
        return detalleMedioPago;
    }

    public void setDetalleMedioPago(String detalleMedioPago) {
        this.detalleMedioPago = detalleMedioPago;
    }

    public MedioPagoModel() {
    }

    public MedioPagoModel(String nombreMedioPago, String detalleMedioPago) {
        this.nombreMedioPago = nombreMedioPago;
        this.detalleMedioPago = detalleMedioPago;
    }

    private MedioPagoModel(int idMedioPago, String nombreMedioPago, String detalleMedioPago) {
        this.idMedioPago = idMedioPago;
        this.nombreMedioPago = nombreMedioPago;
        this.detalleMedioPago = detalleMedioPago;
    }
    
    
      
    public boolean nuevoMedioPago(MedioPagoModel nuevoMedioPago){
    
        int id = 0;
        
        if (!medioPago.isEmpty()) {
            
            for (MedioPagoModel mediosDePagos : medioPago) {
                if (mediosDePagos.getIdMedioPago()> id) {
                    id = mediosDePagos.getIdMedioPago();
                }
            }
            
        }
        
        id++;
        
        medioPago.add(new MedioPagoModel(id, nuevoMedioPago.getNombreMedioPago(), nuevoMedioPago.getDetalleMedioPago()));
         
        return true;
    }
    
    public MedioPagoModel buscaMedioPago(int idMedioPagoBuscado){
    
        MedioPagoModel medioPagoEncontrado = null;
        
        if(!medioPago.isEmpty()){
            for (MedioPagoModel mediosDePago : medioPago) {
                if (mediosDePago.getIdMedioPago()== idMedioPagoBuscado) {
                    medioPagoEncontrado = mediosDePago;
                }
            }
        }
        
        return medioPagoEncontrado;
        
    }
    
    public MedioPagoModel editarMedioPago(int idMedioPago, MedioPagoModel medioPagoEditar){
    
        MedioPagoModel medioPagoEditado = null;
        
        if(!medioPago.isEmpty()){
            for (MedioPagoModel mediosDePago : medioPago) {
                if (mediosDePago.getIdMedioPago()== idMedioPago) {
                    mediosDePago.setNombreMedioPago(medioPagoEditar.getNombreMedioPago());
                    mediosDePago.setDetalleMedioPago(medioPagoEditar.getDetalleMedioPago());
                    
                    medioPagoEditado = mediosDePago;
                }
            }
        }
        
        return medioPagoEditado;
        
    }
    
    public boolean eliminarMedioPago(int id){
        MedioPagoModel medioPagoEliminado = null;
        
        if(!medioPago.isEmpty()){
            for (MedioPagoModel mediosDePago : medioPago) {
                if (mediosDePago.getIdMedioPago()== idMedioPago) {
                   medioPagoEliminado = mediosDePago;
                }
            }
        }
        
        medioPago.remove(medioPagoEliminado);
        
        
        return true;
    }
    
    
    
    
    
}
