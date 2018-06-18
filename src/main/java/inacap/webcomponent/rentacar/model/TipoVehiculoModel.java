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
public class TipoVehiculoModel {
    
     private int idTipoVehiculo;
    private String nombreTipoVehiculo;
    private String detalleTipoVehiculo;
    
    public static ArrayList<TipoVehiculoModel> tipoVehiculo = new ArrayList<>();

    public int getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(int idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public String getNombreTipoVehiculo() {
        return nombreTipoVehiculo;
    }

    public void setNombreTipoVehiculo(String nombreTipoVehiculo) {
        this.nombreTipoVehiculo = nombreTipoVehiculo;
    }

    public String getDetalleTipoVehiculo() {
        return detalleTipoVehiculo;
    }

    public void setDetalleTipoVehiculo(String detalleTipoVehiculo) {
        this.detalleTipoVehiculo = detalleTipoVehiculo;
    }

    public TipoVehiculoModel() {
    }

    public TipoVehiculoModel(String nombreTipoVehiculo, String detalleTipoVehiculo) {
        this.nombreTipoVehiculo = nombreTipoVehiculo;
        this.detalleTipoVehiculo = detalleTipoVehiculo;
    }

    private TipoVehiculoModel(int idTipoVehiculo, String nombreTipoVehiculo, String detalleTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
        this.nombreTipoVehiculo = nombreTipoVehiculo;
        this.detalleTipoVehiculo = detalleTipoVehiculo;
    }
    
    
      
    public boolean nuevoTipoVehiculo(TipoVehiculoModel nuevoTipoVehiculo){
    
        int id = 0;
        
        if (!tipoVehiculo.isEmpty()) {
            
            for (TipoVehiculoModel tiposDeVehiculos : tipoVehiculo) {
                if (tiposDeVehiculos.getIdTipoVehiculo()> id) {
                    id = tiposDeVehiculos.getIdTipoVehiculo();
                }
            }
            
        }
        
        id++;
        
        tipoVehiculo.add(new TipoVehiculoModel(id, nuevoTipoVehiculo.getNombreTipoVehiculo(), nuevoTipoVehiculo.getDetalleTipoVehiculo()));
         
        return true;
    }
    
    public TipoVehiculoModel buscaTipoVehiculo(int idTipoVehiculoBuscado){
    
        TipoVehiculoModel tipoVehiculoEncontrado = null;
        
        if(!tipoVehiculo.isEmpty()){
            for (TipoVehiculoModel tiposDeVehiculos : tipoVehiculo) {
                if (tiposDeVehiculos.getIdTipoVehiculo()== idTipoVehiculoBuscado) {
                    tipoVehiculoEncontrado = tiposDeVehiculos;
                }
            }
        }
        
        return tipoVehiculoEncontrado;
        
    }
    
    public TipoVehiculoModel editarTipoVehiculo(int idTipoVehiculo, TipoVehiculoModel tipoVehiculoEditar){
    
        TipoVehiculoModel tipoVehiculoEditado = null;
        
        if(!tipoVehiculo.isEmpty()){
            for (TipoVehiculoModel tiposDeVehiculos : tipoVehiculo) {
                if (tiposDeVehiculos.getIdTipoVehiculo()== idTipoVehiculo) {
                    tiposDeVehiculos.setNombreTipoVehiculo(tipoVehiculoEditar.getNombreTipoVehiculo());
                    tiposDeVehiculos.setDetalleTipoVehiculo(tipoVehiculoEditar.getDetalleTipoVehiculo());
                    
                    tipoVehiculoEditado = tiposDeVehiculos;
                }
            }
        }
        
        return tipoVehiculoEditado;
        
    }
    
    public boolean eliminarTipoVehiculo(int id){
        TipoVehiculoModel tipoVehiculoEliminado = null;
        
        if(!tipoVehiculo.isEmpty()){
            for (TipoVehiculoModel tiposDeVehiculos : tipoVehiculo) {
                if (tiposDeVehiculos.getIdTipoVehiculo()== idTipoVehiculo) {
                   tipoVehiculoEliminado = tiposDeVehiculos;
                }
            }
        }
        
        tipoVehiculo.remove(tipoVehiculoEliminado);
        
        
        return true;
    }
    
    
    
    
    
}
