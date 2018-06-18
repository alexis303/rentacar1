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
public class TraccionModel {
    private int idTraccion;
    private String nombreTraccion;
    private String detalleTraccion;
    
    public static ArrayList<TraccionModel> traccion = new ArrayList<>();

    public int getIdTraccion() {
        return idTraccion;
    }

    public void setIdTraccion(int idTraccion) {
        this.idTraccion = idTraccion;
    }

    public String getNombreTraccion() {
        return nombreTraccion;
    }

    public void setNombreTraccion(String nombreTraccion) {
        this.nombreTraccion = nombreTraccion;
    }

    public String getDetalleTraccion() {
        return detalleTraccion;
    }

    public void setDetalleTraccion(String detalleTraccion) {
        this.detalleTraccion = detalleTraccion;
    }

    public TraccionModel() {
    }

    public TraccionModel(String nombreTraccion, String detalleTraccion) {
        this.nombreTraccion = nombreTraccion;
        this.detalleTraccion = detalleTraccion;
    }

    private TraccionModel(int idTraccion, String nombreTraccion, String detalleTraccion) {
        this.idTraccion = idTraccion;
        this.nombreTraccion = nombreTraccion;
        this.detalleTraccion = detalleTraccion;
    }
    
      
    public boolean nuevaTraccion(TraccionModel nuevaTraccion){
    
        int id = 0;
        
        if (!traccion.isEmpty()) {
            
            for (TraccionModel tracciones : traccion) {
                if (tracciones.getIdTraccion()> id) {
                    id = tracciones.getIdTraccion();
                }
            }
            
        }
        
        id++;
        
        traccion.add(new TraccionModel(id, nuevaTraccion.getNombreTraccion(), nuevaTraccion.getDetalleTraccion()));
         
        return true;
    }
    
    public TraccionModel buscaTraccion(int idTraccionBuscada){
    
        TraccionModel traccionEncontrada = null;
        
        if(!traccion.isEmpty()){
            for (TraccionModel tracciones : traccion) {
                if (tracciones.getIdTraccion()== idTraccionBuscada) {
                    traccionEncontrada = tracciones;
                }
            }
        }
        
        return traccionEncontrada;
        
    }
    
    public TraccionModel editarTraccion(int idTraccion, TraccionModel traccionEditar){
    
        TraccionModel traccionEditada = null;
        
        if(!traccion.isEmpty()){
            for (TraccionModel tracciones : traccion) {
                if (tracciones.getIdTraccion()== idTraccion) {
                    tracciones.setNombreTraccion(traccionEditar.getNombreTraccion());
                    tracciones.setDetalleTraccion(traccionEditar.getDetalleTraccion());
                    
                    traccionEditada = tracciones;
                }
            }
        }
        
        return traccionEditada;
        
    }
    
    public boolean eliminarTraccion(int id){
        TraccionModel traccionEliminada = null;
        
        if(!traccion.isEmpty()){
            for (TraccionModel tracciones : traccion) {
                if (tracciones.getIdTraccion()== idTraccion) {
                   traccionEliminada = tracciones;
                }
            }
        }
        
        traccion.remove(traccionEliminada);
        
        
        return true;
    }
    
    
    
}
