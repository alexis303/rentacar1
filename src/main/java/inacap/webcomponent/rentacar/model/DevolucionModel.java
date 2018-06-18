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
public class DevolucionModel {

    private int idDevolucion;
    private Date fechaDevolucion;
    private Time horaDevolucion;
    private ArriendoModel Arriendo;

    public static ArrayList<DevolucionModel> devolucion = new ArrayList<>();

    public int getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(int idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Time getHoraDevolucion() {
        return horaDevolucion;
    }

    public void setHoraDevolucion(Time horaDevolucion) {
        this.horaDevolucion = horaDevolucion;
    }

    public ArriendoModel getArriendo() {
        return Arriendo;
    }

    public void setArriendo(ArriendoModel Arriendo) {
        this.Arriendo = Arriendo;
    }

    public DevolucionModel() {
    }

    public DevolucionModel(Date fechaDevolucion, Time horaDevolucion, ArriendoModel Arriendo) {
        this.fechaDevolucion = fechaDevolucion;
        this.horaDevolucion = horaDevolucion;
        this.Arriendo = Arriendo;
    }

    private DevolucionModel(int idDevolucion, Date fechaDevolucion, Time horaDevolucion, ArriendoModel Arriendo) {
        this.idDevolucion = idDevolucion;
        this.fechaDevolucion = fechaDevolucion;
        this.horaDevolucion = horaDevolucion;
        this.Arriendo = Arriendo;
    }

    public boolean nuevaDevolucion(DevolucionModel nuevaDevolucion) {

        int id = 0;

        if (!devolucion.isEmpty()) {

            for (DevolucionModel devoluciones : devolucion) {
                if (devoluciones.getIdDevolucion()> id) {
                    id = devoluciones.getIdDevolucion();
                }
            }

        }

        id++;

        devolucion.add(new DevolucionModel(id, nuevaDevolucion.getFechaDevolucion(), nuevaDevolucion.getHoraDevolucion(),nuevaDevolucion.getArriendo()));

        return true;
    }

    public DevolucionModel buscaDevolucion(int idDevolucionBuscada) {

        DevolucionModel devolucionEncontrada = null;

        if (!devolucion.isEmpty()) {
            for (DevolucionModel devoluciones : devolucion) {
                if (devoluciones.getIdDevolucion()== idDevolucionBuscada) {
                    devolucionEncontrada = devoluciones;
                }
            }
        }

        return devolucionEncontrada;

    }

    public DevolucionModel editarDevolucion(int idDevolucion, DevolucionModel devolucionEditar) {

        DevolucionModel devolucionEditada = null;

        if (!devolucion.isEmpty()) {
            for (DevolucionModel devoluciones : devolucion) {
                if (devoluciones.getIdDevolucion()== idDevolucion) {
                    devoluciones.setFechaDevolucion(devolucionEditar.getFechaDevolucion());
                    devoluciones.setHoraDevolucion(devolucionEditar.getHoraDevolucion());

                    devolucionEditada = devoluciones;
                }
            }
        }

        return devolucionEditada;

    }

    public boolean eliminarDevolucion(int id) {
        DevolucionModel devolucionEliminada = null;

        if (!devolucion.isEmpty()) {
            for (DevolucionModel devoluciones : devolucion) {
                if (devoluciones.getIdDevolucion()== idDevolucion) {
                    devolucionEliminada = devoluciones;
                }
            }
        }

        devolucion.remove(devolucionEliminada);

        return true;
    }

}
