/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Alexis
 */
public class ArriendoModel {
    private int idArriendo;
    private Date fechaArriendo;
    private Time horaArriendo;
    private PersonaModel vendedor;
    private PersonaModel cliente;
    private VehiculoModel vehiculo;
    private MedioPagoModel medioPago;
    
    public static ArrayList<ArriendoModel> arriendo = new ArrayList<>();

    public int getIdArriendo() {
        return idArriendo;
    }

    public void setIdArriendo(int idArriendo) {
        this.idArriendo = idArriendo;
    }

    public Date getFechaArriendo() {
        return fechaArriendo;
    }

    public void setFechaArriendo(Date fechaArriendo) {
        this.fechaArriendo = fechaArriendo;
    }

    public Time getHoraArriendo() {
        return horaArriendo;
    }

    public void setHoraArriendo(Time horaArriendo) {
        this.horaArriendo = horaArriendo;
    }

    public PersonaModel getVendedor() {
        return vendedor;
    }

    public void setVendedor(PersonaModel vendedor) {
        this.vendedor = vendedor;
    }

    public PersonaModel getCliente() {
        return cliente;
    }

    public void setCliente(PersonaModel cliente) {
        this.cliente = cliente;
    }

    public VehiculoModel getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoModel vehiculo) {
        this.vehiculo = vehiculo;
    }

    public MedioPagoModel getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPagoModel medioPago) {
        this.medioPago = medioPago;
    }

    public ArriendoModel() {
    }

    public ArriendoModel(Date fechaArriendo, Time horaArriendo, PersonaModel vendedor, PersonaModel cliente, VehiculoModel vehiculo, MedioPagoModel medioPago) {
        this.fechaArriendo = fechaArriendo;
        this.horaArriendo = horaArriendo;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.medioPago = medioPago;
    }

    private ArriendoModel(int idArriendo, Date fechaArriendo, Time horaArriendo, PersonaModel vendedor, PersonaModel cliente, VehiculoModel vehiculo, MedioPagoModel medioPago) {
        this.idArriendo = idArriendo;
        this.fechaArriendo = fechaArriendo;
        this.horaArriendo = horaArriendo;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.medioPago = medioPago;
    }
    
    
    
    
    
     public boolean nuevoArriendo(ArriendoModel nuevoArriendo){
    
        int id = 0;
        
        if (!arriendo.isEmpty()) {
            
            for (ArriendoModel arriendos : arriendo) {
                if (arriendos.getIdArriendo()> id) {
                    id = arriendos.getIdArriendo();
                }
            }
            
        }
        
        id++;
        
        arriendo.add(new ArriendoModel(id, nuevoArriendo.getFechaArriendo(), nuevoArriendo.getHoraArriendo(), nuevoArriendo.getVendedor(), nuevoArriendo.getCliente(), nuevoArriendo.getVehiculo(), nuevoArriendo.getMedioPago()));
         
        return true;
    }
    
    public ArriendoModel buscaArriendo(int idArriendoBuscado){
    
        ArriendoModel arriendoEncontrado = null;
        
        if(!arriendo.isEmpty()){
            for (ArriendoModel arriendos : arriendo) {
                if (arriendos.getIdArriendo()== idArriendoBuscado) {
                    arriendoEncontrado = arriendos;
                }
            }
        }
        
        return arriendoEncontrado;
        
    }
    
    public ArriendoModel editarArriendo(int idArriendo, ArriendoModel arriendoEditar){
    
        ArriendoModel ArriendoEditado = null;
        
        if(!arriendo.isEmpty()){
            for (ArriendoModel arriendos : arriendo) {
                if (arriendos.getIdArriendo()== idArriendo) {
                    arriendos.setFechaArriendo(arriendoEditar.getFechaArriendo());
                    arriendos.setHoraArriendo(arriendoEditar.getHoraArriendo());
                    
                    ArriendoEditado = arriendos;
                }
            }
        }
        
        return ArriendoEditado;
        
    }
    
    public boolean eliminarArriendo(int id){
        ArriendoModel arriendoEliminado = null;
        
        if(!arriendo.isEmpty()){
            for (ArriendoModel arriendos : arriendo) {
                if (arriendos.getIdArriendo()== idArriendo) {
                   arriendoEliminado = arriendos;
                }
            }
        }
        
        arriendo.remove(arriendoEliminado);
        
        
        return true;
    }
    
    
    
    
    
    
    
}
