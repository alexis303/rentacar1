/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.model;

import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "persona")
public class PersonaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idPersona;
    private String rutPersona;
    private String nombrePersona;
    private String apellidoPersona;
    private Date fechaNacimiento;
    private String telefonoPersona;
    private String direccion1Persona;
    private String direccion2Persona;
    @ManyToOne
    @JoinColumn(name = "id_ciudad")
    private CiudadModel ciudad;
    
    @ManyToOne
    @JoinColumn(name = "id_tipo_persona")
    private TipoPersonaModel tipoPersona;

    

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getRutPersona() {
        return rutPersona;
    }

    public void setRutPersona(String rutPersona) {
        this.rutPersona = rutPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefonoPersona() {
        return telefonoPersona;
    }

    public void setTelefonoPersona(String telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
    }

    public String getDireccion1Persona() {
        return direccion1Persona;
    }

    public void setDireccion1Persona(String direccion1Persona) {
        this.direccion1Persona = direccion1Persona;
    }

    public String getDireccion2Persona() {
        return direccion2Persona;
    }

    public void setDireccion2Persona(String direccion2Persona) {
        this.direccion2Persona = direccion2Persona;
    }

    public CiudadModel getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadModel ciudad) {
        this.ciudad = ciudad;
    }

    public TipoPersonaModel getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersonaModel tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public PersonaModel() {
    }

    public PersonaModel(String rutPersona, String nombrePersona, String apellidoPersona, Date fechaNacimiento, String telefonoPersona, String direccion1Persona, String direccion2Persona, CiudadModel ciudad, TipoPersonaModel tipoPersona) {
        this.rutPersona = rutPersona;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.fechaNacimiento = fechaNacimiento;
        this.telefonoPersona = telefonoPersona;
        this.direccion1Persona = direccion1Persona;
        this.direccion2Persona = direccion2Persona;
        this.ciudad = ciudad;
        this.tipoPersona = tipoPersona;
    }

    private PersonaModel(int idPersona, String rutPersona, String nombrePersona, String apellidoPersona, Date fechaNacimiento, String telefonoPersona, String direccion1Persona, String direccion2Persona, CiudadModel ciudad, TipoPersonaModel tipoPersona) {
        this.idPersona = idPersona;
        this.rutPersona = rutPersona;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.fechaNacimiento = fechaNacimiento;
        this.telefonoPersona = telefonoPersona;
        this.direccion1Persona = direccion1Persona;
        this.direccion2Persona = direccion2Persona;
        this.ciudad = ciudad;
        this.tipoPersona = tipoPersona;
    }


}
