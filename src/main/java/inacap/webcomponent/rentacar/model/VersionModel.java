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
public class VersionModel {
    
    private int idVersion;
    private String nombreVersion;
    private String detalleVersion;
    private int puertas;
    private  int pasajeros;
    private float cilindrada;
    private float rendimiento;
    private int capacidadMaletero;
    private int airbags;
    private boolean aireAcondicionado;
    private boolean cierreCentralizado;
    private boolean alzaVidriosElectricos;
    private boolean camaraRetroceso;
    private CombustibleModel combustible;
    private CarroceriaModel carroceria;
    private TransmisionModel transmision;
    private TraccionModel traccion;
    private ModeloModel modelo;
    
    public static ArrayList<VersionModel> version = new ArrayList<>();
    private VersionModel AireAcondicionado;
    private VersionModel CierreCentralizado;
    private VersionModel AlzaVidriosElectricos;
    private VersionModel CamaraRetroceso;

    public int getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(int idVersion) {
        this.idVersion = idVersion;
    }

    public String getNombreVersion() {
        return nombreVersion;
    }

    public void setNombreVersion(String nombreVersion) {
        this.nombreVersion = nombreVersion;
    }

    public String getDetalleVersion() {
        return detalleVersion;
    }

    public void setDetalleVersion(String detalleVersion) {
        this.detalleVersion = detalleVersion;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public float getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(float cilindrada) {
        this.cilindrada = cilindrada;
    }

    public float getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(float rendimiento) {
        this.rendimiento = rendimiento;
    }

    public int getCapacidadMaletero() {
        return capacidadMaletero;
    }

    public void setCapacidadMaletero(int capacidadMaletero) {
        this.capacidadMaletero = capacidadMaletero;
    }

    public int getAirbags() {
        return airbags;
    }

    public void setAirbags(int airbags) {
        this.airbags = airbags;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean isCierreCentralizado() {
        return cierreCentralizado;
    }

    public void setCierreCentralizado(boolean cierreCentralizado) {
        this.cierreCentralizado = cierreCentralizado;
    }

    public boolean isAlzaVidriosElectricos() {
        return alzaVidriosElectricos;
    }

    public void setAlzaVidriosElectricos(boolean alzaVidriosElectricos) {
        this.alzaVidriosElectricos = alzaVidriosElectricos;
    }

    public boolean isCamaraRetroceso() {
        return camaraRetroceso;
    }

    public void setCamaraRetroceso(boolean camaraRetroceso) {
        this.camaraRetroceso = camaraRetroceso;
    }

    public CombustibleModel getCombustible() {
        return combustible;
    }

    public void setCombustible(CombustibleModel combustible) {
        this.combustible = combustible;
    }

    public CarroceriaModel getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(CarroceriaModel carroceria) {
        this.carroceria = carroceria;
    }

    public TransmisionModel getTransmision() {
        return transmision;
    }

    public void setTransmision(TransmisionModel transmision) {
        this.transmision = transmision;
    }

    public TraccionModel getTraccion() {
        return traccion;
    }

    public void setTraccion(TraccionModel traccion) {
        this.traccion = traccion;
    }

    public ModeloModel getModelo() {
        return modelo;
    }

    public void setModelo(ModeloModel modelo) {
        this.modelo = modelo;
    }

    public VersionModel() {
    }

    public VersionModel(String nombreVersion, String detalleVersion, int puertas, int pasajeros, float cilindrada, float rendimiento, int capacidadMaletero, int airbags, boolean aireAcondicionado, boolean cierreCentralizado, boolean alzaVidriosElectricos, boolean camaraRetroceso, CombustibleModel combustible, CarroceriaModel carroceria, TransmisionModel transmision, TraccionModel traccion, ModeloModel modelo) {
        this.nombreVersion = nombreVersion;
        this.detalleVersion = detalleVersion;
        this.puertas = puertas;
        this.pasajeros = pasajeros;
        this.cilindrada = cilindrada;
        this.rendimiento = rendimiento;
        this.capacidadMaletero = capacidadMaletero;
        this.airbags = airbags;
        this.aireAcondicionado = aireAcondicionado;
        this.cierreCentralizado = cierreCentralizado;
        this.alzaVidriosElectricos = alzaVidriosElectricos;
        this.camaraRetroceso = camaraRetroceso;
        this.combustible = combustible;
        this.carroceria = carroceria;
        this.transmision = transmision;
        this.traccion = traccion;
        this.modelo = modelo;
    }

    private VersionModel(int idVersion, String nombreVersion, String detalleVersion, int puertas, int pasajeros, float cilindrada, float rendimiento, int capacidadMaletero, int airbags, boolean aireAcondicionado, boolean cierreCentralizado, boolean alzaVidriosElectricos, boolean camaraRetroceso, CombustibleModel combustible, CarroceriaModel carroceria, TransmisionModel transmision, TraccionModel traccion, ModeloModel modelo) {
        this.idVersion = idVersion;
        this.nombreVersion = nombreVersion;
        this.detalleVersion = detalleVersion;
        this.puertas = puertas;
        this.pasajeros = pasajeros;
        this.cilindrada = cilindrada;
        this.rendimiento = rendimiento;
        this.capacidadMaletero = capacidadMaletero;
        this.airbags = airbags;
        this.aireAcondicionado = aireAcondicionado;
        this.cierreCentralizado = cierreCentralizado;
        this.alzaVidriosElectricos = alzaVidriosElectricos;
        this.camaraRetroceso = camaraRetroceso;
        this.combustible = combustible;
        this.carroceria = carroceria;
        this.transmision = transmision;
        this.traccion = traccion;
        this.modelo = modelo;
    }
    
    
      
    public boolean nuevaVersion(VersionModel nuevaVersion){
    
        int id = 0;
        
        if (!version.isEmpty()) {
            
            for (VersionModel versiones : version) {
                if (versiones.getIdVersion()> id) {
                    id = versiones.getIdVersion();
                }
            }
            
        }
        
        id++;
        
        version.add(new VersionModel(id, nuevaVersion.getNombreVersion(), nuevaVersion.getDetalleVersion(), nuevaVersion.getPuertas(), nuevaVersion.getPasajeros(), nuevaVersion.getCilindrada(), nuevaVersion.getRendimiento(), nuevaVersion.getCapacidadMaletero(), nuevaVersion.getAirbags(), nuevaVersion(nuevaVersion.AireAcondicionado), nuevaVersion(nuevaVersion.CierreCentralizado), nuevaVersion(nuevaVersion.AlzaVidriosElectricos), nuevaVersion(nuevaVersion.CamaraRetroceso), nuevaVersion.getCombustible(), nuevaVersion.getCarroceria(), nuevaVersion.getTransmision(), nuevaVersion.getTraccion(), nuevaVersion.getModelo()));
         
        return true;
    }
    
    public VersionModel buscaVersion(int idVersionBuscada){
    
        VersionModel versionEncontrada = null;
        
        if(!version.isEmpty()){
            for (VersionModel versiones : version) {
                if (versiones.getIdVersion()== idVersionBuscada) {
                    versionEncontrada = versiones;
                }
            }
        }
        
        return versionEncontrada;
        
    }
    
    public VersionModel editarVersion(int idVersion, VersionModel versionEditar){
    
        VersionModel versionEditada = null;
        
        if(!version.isEmpty()){
            for (VersionModel versiones : version) {
                if (versiones.getIdVersion()== idVersion) {
                    versiones.setNombreVersion(versionEditar.getNombreVersion());
                    versiones.setDetalleVersion(versionEditar.getDetalleVersion());
                    versiones.setPuertas(versionEditar.getPuertas());
                    versiones.setPasajeros(versionEditar.getPasajeros());
                    versiones.setCilindrada(versionEditar.getCilindrada());
                    versiones.setRendimiento(versionEditar.getRendimiento());
                    versiones.setCapacidadMaletero(versionEditar.getCapacidadMaletero());
                    versiones.setAirbags(versionEditar.getAirbags());
                    versiones.setAireAcondicionado(aireAcondicionado);
                    versiones.setCierreCentralizado(cierreCentralizado);
                    versiones.setAlzaVidriosElectricos(alzaVidriosElectricos);
                    versiones.setCamaraRetroceso(camaraRetroceso);
                    
                    
                    versionEditada = versiones;
                }
            }
        }
        
        return versionEditada;
        
    }
    
    public boolean eliminarVersion(int id){
        VersionModel versionEliminada = null;
        
        if(!version.isEmpty()){
            for (VersionModel versiones : version) {
                if (versiones.getIdVersion()== idVersion) {
                   versionEliminada = versiones;
                }
            }
        }
        
        version.remove(versionEliminada);
        
        
        return true;
    }
    
    
    
    
    
}
