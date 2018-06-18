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
public class CiudadModel {

    private int idCiudad;
    private String nombreCiudad;
    private String detalleCiudad;
    
    private RegionModel region;
    
   public static ArrayList<CiudadModel> ciudad =new ArrayList<>();

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getDetalleCiudad() {
        return detalleCiudad;
    }

    public void setDetalleCiudad(String detalleCiudad) {
        this.detalleCiudad = detalleCiudad;
    }

    public RegionModel getRegion() {
        return region;
    }

    public void setRegion(RegionModel region) {
        this.region = region;
    }

    public CiudadModel() {
    }

    public CiudadModel(String nombreCiudad, String detalleCiudad, RegionModel region) {
        this.nombreCiudad = nombreCiudad;
        this.detalleCiudad = detalleCiudad;
        this.region = region;
    }

    private CiudadModel(int idCiudad, String nombreCiudad, String detalleCiudad, RegionModel region) {
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
        this.detalleCiudad = detalleCiudad;
        this.region = region;
    }
    
    
     public boolean nuevaCiudad(CiudadModel nuevaCiudad){
    
        int id = 0;
        
        if (!ciudad.isEmpty()) {
            
            for (CiudadModel ciudades : ciudad) {
                if (ciudades.getIdCiudad()> id) {
                    id = ciudades.getIdCiudad();
                }
            }
            
        }
        
        id++;
        
        ciudad.add(new CiudadModel(id, nuevaCiudad.getNombreCiudad(), nuevaCiudad.getDetalleCiudad(), nuevaCiudad.getRegion()));
         
        return true;
    }
    
    public CiudadModel buscaCiudad(int idciudadBuscada){
    
        CiudadModel ciudadEncontrada = null;
        
        if(!ciudad.isEmpty()){
            for (CiudadModel ciudades : ciudad) {
                if (ciudades.getIdCiudad()== idciudadBuscada) {
                    ciudadEncontrada = ciudades;
                }
            }
        }
        
        return ciudadEncontrada;
        
    }
    
    public CiudadModel editarCiudad(int idCiudad, CiudadModel CiudadEditar){
    
        CiudadModel ciudadEditada = null;
        
        if(!ciudad.isEmpty()){
            for (CiudadModel ciudades : ciudad) {
                if (ciudades.getIdCiudad()== idCiudad) {
                    ciudades.setNombreCiudad(CiudadEditar.getNombreCiudad());
                    ciudades.setDetalleCiudad(CiudadEditar.getDetalleCiudad());
                    
                    ciudadEditada = ciudades;
                }
            }
        }
        
        return ciudadEditada;
        
    }
    
    public boolean eliminarCiudad(int id){
        CiudadModel ciudadEliminada = null;
        
        if(!ciudad.isEmpty()){
            for (CiudadModel ciudades : ciudad) {
                if (ciudades.getIdCiudad()== idCiudad) {
                   ciudadEliminada = ciudades;
                }
            }
        }
        
        ciudad.remove(ciudadEliminada);
        
        
        return true;
    }
    
    
    
    

   
}
