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
public class VehiculoModel {
    private int idVehiculo;
    private String patente;
    private int valor;
    private int año;
    private String color;
    private TipoVehiculoModel tipoVehiculo;
    private VersionModel version;
    
    public static ArrayList<VehiculoModel> vehiculo = new ArrayList<>();

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public TipoVehiculoModel getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculoModel tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public VersionModel getVersion() {
        return version;
    }

    public void setVersion(VersionModel version) {
        this.version = version;
    }

    public VehiculoModel() {
    }

    public VehiculoModel(String patente, int valor, int año, String color, TipoVehiculoModel tipoVehiculo, VersionModel version) {
        this.patente = patente;
        this.valor = valor;
        this.año = año;
        this.color = color;
        this.tipoVehiculo = tipoVehiculo;
        this.version = version;
    }

    private VehiculoModel(int idVehiculo, String patente, int valor, int año, String color, TipoVehiculoModel tipoVehiculo, VersionModel version) {
        this.idVehiculo = idVehiculo;
        this.patente = patente;
        this.valor = valor;
        this.año = año;
        this.color = color;
        this.tipoVehiculo = tipoVehiculo;
        this.version = version;
    }
    
      
    public boolean nuevoVehiculo(VehiculoModel nuevoVehiculo){
    
        int id = 0;
        
        if (!vehiculo.isEmpty()) {
            
            for (VehiculoModel vehiculos : vehiculo) {
                if (vehiculos.getIdVehiculo()> id) {
                    id = vehiculos.getIdVehiculo();
                }
            }
            
        }
        
        id++;
        
        vehiculo.add(new VehiculoModel(id, nuevoVehiculo.getPatente(), nuevoVehiculo.getValor(), nuevoVehiculo.getAño(), nuevoVehiculo.getColor(), nuevoVehiculo.getTipoVehiculo(), nuevoVehiculo.getVersion()));
         
        return true;
    }
    
    public VehiculoModel buscaVehiculo(int idVehiculoBuscado){
    
        VehiculoModel vehiculoEncontrado = null;
        
        if(!vehiculo.isEmpty()){
            for (VehiculoModel vehiculos : vehiculo) {
                if (vehiculos.getIdVehiculo()== idVehiculoBuscado) {
                    vehiculoEncontrado = vehiculos;
                }
            }
        }
        
        return vehiculoEncontrado;
        
    }
    
    public VehiculoModel editarVehiculo(int idVehiculo, VehiculoModel vehiculoEditar){
    
        VehiculoModel vehiculoEditado = null;
        
        if(!vehiculo.isEmpty()){
            for (VehiculoModel vehiculos : vehiculo) {
                if (vehiculos.getIdVehiculo()== idVehiculo) {
                    vehiculos.setPatente(vehiculoEditar.getPatente());
                    vehiculos.setValor(vehiculoEditar.getValor());
                    vehiculos.setAño(vehiculoEditar.getAño());
                    vehiculos.setColor(vehiculoEditar.getColor());
                    
                    
                    
                    vehiculoEditado = vehiculos;
                }
            }
        }
        
        return vehiculoEditado;
        
    }
    
    public boolean eliminarVehiculo(int id){
        VehiculoModel vehiculoEliminado = null;
        
        if(!vehiculo.isEmpty()){
            for (VehiculoModel vehiculos : vehiculo) {
                if (vehiculos.getIdVehiculo()== idVehiculo) {
                   vehiculoEliminado = vehiculos;
                }
            }
        }
        
        vehiculo.remove(vehiculoEliminado);
        
        
        return true;
    }
    
    
}
