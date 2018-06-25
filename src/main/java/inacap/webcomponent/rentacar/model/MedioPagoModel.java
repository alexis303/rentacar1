
package inacap.webcomponent.rentacar.model;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MedioPago")
public class MedioPagoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
     private int idMedioPago;
    private String nombreMedioPago;
    private String detalleMedioPago;
    
    public static ArrayList<MedioPagoModel> medioPago = new ArrayList<>();

    public int getIdMedioPago() {
        return idMedioPago;
    }

    public void setIdMedioPago(int idMedioPago) {
        this.idMedioPago = idMedioPago;
    }

    public String getNombreMedioPago() {
        return nombreMedioPago;
    }

    public void setNombreMedioPago(String nombreMedioPago) {
        this.nombreMedioPago = nombreMedioPago;
    }

    public String getDetalleMedioPago() {
        return detalleMedioPago;
    }

    public void setDetalleMedioPago(String detalleMedioPago) {
        this.detalleMedioPago = detalleMedioPago;
    }

    public MedioPagoModel() {
    }

    public MedioPagoModel(String nombreMedioPago, String detalleMedioPago) {
        this.nombreMedioPago = nombreMedioPago;
        this.detalleMedioPago = detalleMedioPago;
    }

    private MedioPagoModel(int idMedioPago, String nombreMedioPago, String detalleMedioPago) {
        this.idMedioPago = idMedioPago;
        this.nombreMedioPago = nombreMedioPago;
        this.detalleMedioPago = detalleMedioPago;
    }
    
    
      
    
    
}
