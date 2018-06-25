/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.model;



@Entity
@Table(name=TipoPersona)
public class TipoPersonaModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int idTipoPersona;
    private String nombreTipoPersona;
    private String detalleTipoPersona;
    
    

    public int getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(int idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public String getNombreTipoPersona() {
        return nombreTipoPersona;
    }

    public void setNombreTipoPersona(String nombreTipoPersona) {
        this.nombreTipoPersona = nombreTipoPersona;
    }

    public String getDetalleTipoPersona() {
        return detalleTipoPersona;
    }

    public void setDetalleTipoPersona(String detalleTipoPersona) {
        this.detalleTipoPersona = detalleTipoPersona;
    }

    public TipoPersonaModel() {
    }

    public TipoPersonaModel(String nombreTipoPersona, String detalleTipoPersona) {
        this.nombreTipoPersona = nombreTipoPersona;
        this.detalleTipoPersona = detalleTipoPersona;
    }

    private TipoPersonaModel(int idTipoPersona, String nombreTipoPersona, String detalleTipoPersona) {
        this.idTipoPersona = idTipoPersona;
        this.nombreTipoPersona = nombreTipoPersona;
        this.detalleTipoPersona = detalleTipoPersona;
    }
    
    
      
    
    
}
