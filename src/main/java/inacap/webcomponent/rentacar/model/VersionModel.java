/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.model;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Alexis
 */
@Entity
@Table(name = "version")
public class VersionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idVersion;
    private String nombreVersion;
    private String detalleVersion;
    private int puertas;
    private int pasajeros;
    private float cilindrada;
    private float rendimiento;
    private int capacidadMaletero;
    private int airbags;
    private boolean aireAcondicionado;
    private boolean cierreCentralizado;
    private boolean alzaVidriosElectricos;
    private boolean camaraRetroceso;

    @ManyToOne
    @JoinColumn(name = "id_combustible")
    private CombustibleModel combustible;

    @ManyToOne
    @JoinColumn(name = "id_carroceria")
    private CarroceriaModel carroceria;

    @ManyToOne
    @JoinColumn(name = "id_transmision")
    private TransmisionModel transmision;

    @ManyToOne
    @JoinColumn(name = "id_traccion")
    private TraccionModel traccion;

    @ManyToOne
    @JoinColumn(name = "id_modelo")
    private ModeloModel modelo;

   

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

}
