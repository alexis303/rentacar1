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
public class MarcaModel {
    
    private int idMarca;
    private String nombreMarca;
    private String detalleMarca;
    public static ArrayList<MarcaModel> marca = new ArrayList<>();

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getDetalleMarca() {
        return detalleMarca;
    }

    public void setDetalleMarca(String detalleMarca) {
        this.detalleMarca = detalleMarca;
    }

    public MarcaModel() {
    }

    public MarcaModel(String nombreMarca, String detalleMarca) {
        this.nombreMarca = nombreMarca;
        this.detalleMarca = detalleMarca;
    }

    private MarcaModel(int idMarca, String nombreMarca, String detalleMarca) {
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
        this.detalleMarca = detalleMarca;
    }
    
     public boolean nuevaMarca(MarcaModel nuevaMarca){
    
        int id = 0;
        
        if (!marca.isEmpty()) {
            
            for (MarcaModel marcas : marca) {
                if (marcas.getIdMarca()> id) {
                    id = marcas.getIdMarca();
                }
            }
            
        }
        
        id++;
        
        marca.add(new MarcaModel(id, nuevaMarca.getNombreMarca(), nuevaMarca.getDetalleMarca()));
         
        return true;
    }
    
    public MarcaModel buscaMarca(int idMarcaBuscada){
    
        MarcaModel marcaEncontrada = null;
        
        if(!marca.isEmpty()){
            for (MarcaModel marcas : marca) {
                if (marcas.getIdMarca()== idMarcaBuscada) {
                    marcaEncontrada = marcas;
                }
            }
        }
        
        return marcaEncontrada;
        
    }
    
    public MarcaModel editarMarca(int idMarca, MarcaModel marcaEditar){
    
        MarcaModel marcaEditada = null;
        
        if(!marca.isEmpty()){
            for (MarcaModel marcas : marca) {
                if (marcas.getIdMarca()== idMarca) {
                    marcas.setNombreMarca(marcaEditar.getNombreMarca());
                    marcas.setDetalleMarca(marcaEditar.getDetalleMarca());
                    
                    marcaEditada = marcas;
                }
            }
        }
        
        return marcaEditada;
        
    }
    
    public boolean eliminarMarca(int id){
        MarcaModel marcaEliminada = null;
        
        if(!marca.isEmpty()){
            for (MarcaModel marcas : marca) {
                if (marcas.getIdMarca()== idMarca) {
                   marcaEliminada = marcas;
                }
            }
        }
        
        marca.remove(marcaEliminada);
        
        
        return true;
    }
    
    
    
}
