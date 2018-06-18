/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Alexis
 */
public class PersonaModel {

    private int idPersona;
    private String rutPersona;
    private String nombrePersona;
    private String apellidoPersona;
    private Date fechaNacimiento;
    private String telefonoPersona;
    private String direccion1Persona;
    private String direccion2Persona;

    private CiudadModel ciudad;
    private TipoPersonaModel tipoPersona;

    public static ArrayList<PersonaModel> persona = new ArrayList<>();

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
    
    
    
      
    public boolean nuevaPersona(PersonaModel nuevaPersona){
    
        int id = 0;
        
        if (!persona.isEmpty()) {
            
            for (PersonaModel personas : persona) {
                if (personas.getIdPersona()> id) {
                    id = personas.getIdPersona();
                }
            }
            
        }
        
        id++;
        
        persona.add(new PersonaModel(id, nuevaPersona.getRutPersona(), nuevaPersona.getNombrePersona(), nuevaPersona.getApellidoPersona(), nuevaPersona.getFechaNacimiento(), nuevaPersona.getTelefonoPersona(), nuevaPersona.getDireccion1Persona(), nuevaPersona.getDireccion2Persona(), nuevaPersona.getCiudad(), nuevaPersona.getTipoPersona()));
         
        return true;
    }
    
    public PersonaModel buscaPersona(int idPersonaBuscada){
    
        PersonaModel personaEncontrada = null;
        
        if(!persona.isEmpty()){
            for (PersonaModel personas : persona) {
                if (personas.getIdPersona()== idPersonaBuscada) {
                    personaEncontrada = personas;
                }
            }
        }
        
        return personaEncontrada;
        
    }
    
    public PersonaModel editarPersona(int idPersona, PersonaModel personaEditar){
    
        PersonaModel personaEditada = null;
        
        if(!persona.isEmpty()){
            for (PersonaModel personas : persona) {
                if (personas.getIdPersona()== idPersona) {
                    personas.setRutPersona(personaEditar.getRutPersona());
                    personas.setNombrePersona(personaEditar.getNombrePersona());
                    personas.setApellidoPersona(personaEditar.getApellidoPersona());
                    personas.setFechaNacimiento(personaEditar.getFechaNacimiento());
                    personas.setTelefonoPersona(personaEditar.getTelefonoPersona());
                    personas.setDireccion1Persona(personaEditar.getDireccion1Persona());
                    personas.setDireccion2Persona(personaEditar.getDireccion2Persona());
                    
                    
                    personaEditada = personas;
                }
            }
        }
        
        return personaEditada;
        
    }
    
    public boolean eliminarPersona(int id){
        PersonaModel personaEliminada = null;
        
        if(!persona.isEmpty()){
            for (PersonaModel personas : persona) {
                if (personas.getIdPersona()== idPersona) {
                   personaEliminada = personas;
                }
            }
        }
        
        persona.remove(personaEliminada);
        
        
        return true;
    }
    

}
