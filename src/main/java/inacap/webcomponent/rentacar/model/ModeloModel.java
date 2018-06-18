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
public class ModeloModel {
    private int idModelo;
    private String nombreModelo;
    private String detalleModelo;
    private MarcaModel marca;
    
    public static ArrayList<ModeloModel> modelo = new ArrayList<>();

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public String getDetalleModelo() {
        return detalleModelo;
    }

    public void setDetalleModelo(String detalleModelo) {
        this.detalleModelo = detalleModelo;
    }

    public MarcaModel getMarca() {
        return marca;
    }

    public void setMarca(MarcaModel marca) {
        this.marca = marca;
    }

    public ModeloModel() {
    }

    public ModeloModel(String nombreModelo, String detalleModelo, MarcaModel marca) {
        this.nombreModelo = nombreModelo;
        this.detalleModelo = detalleModelo;
        this.marca = marca;
    }

    private ModeloModel(int idModelo, String nombreModelo, String detalleModelo, MarcaModel marca) {
        this.idModelo = idModelo;
        this.nombreModelo = nombreModelo;
        this.detalleModelo = detalleModelo;
        this.marca = marca;
    }
    
      
    public boolean nuevoModelo(ModeloModel nuevoModelo){
    
        int id = 0;
        
        if (!modelo.isEmpty()) {
            
            for (ModeloModel modelos : modelo) {
                if (modelos.getIdModelo()> id) {
                    id = modelos.getIdModelo();
                }
            }
            
        }
        
        id++;
        
        modelo.add(new ModeloModel(id, nuevoModelo.getNombreModelo(), nuevoModelo.getDetalleModelo(), nuevoModelo.getMarca()));
         
        return true;
    }
    
    public ModeloModel buscaModelo(int idModeloBuscado){
    
        ModeloModel modeloEncontrado = null;
        
        if(!modelo.isEmpty()){
            for (ModeloModel modelos : modelo) {
                if (modelos.getIdModelo()== idModeloBuscado) {
                    modeloEncontrado = modelos;
                }
            }
        }
        
        return modeloEncontrado;
        
    }
    
    public ModeloModel editarModelo(int idModelo, ModeloModel modeloEditar){
    
        ModeloModel modeloEditado = null;
        
        if(!modelo.isEmpty()){
            for (ModeloModel modelos : modelo) {
                if (modelos.getIdModelo()== idModelo) {
                    modelos.setNombreModelo(modeloEditar.getNombreModelo());
                    modelos.setDetalleModelo(modeloEditar.getDetalleModelo());
                    
                    modeloEditado = modelos;
                }
            }
        }
        
        return modeloEditado;
        
    }
    
    public boolean eliminarModelo(int id){
        ModeloModel modeloEliminado = null;
        
        if(!modelo.isEmpty()){
            for (ModeloModel modelos : modelo) {
                if (modelos.getIdModelo()== idModelo) {
                   modeloEliminado = modelos;
                }
            }
        }
        
        modelo.remove(modeloEliminado);
        
        
        return true;
    }
    
    
    
}
