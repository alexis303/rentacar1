/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.model;

import java.util.ArrayList;

/**
 *
 * @author 19798398-1
 */
public class CarroceriaModel {

    private int idCarroceria;
    private String nombreCarroceria;
    private String detalleCarroceria;

    public static ArrayList<CarroceriaModel> carroceria = new ArrayList<>();

    public int getIdCarroceria() {
        return idCarroceria;
    }

    public void setIdCarroceria(int idCarroceria) {
        this.idCarroceria = idCarroceria;
    }

    public String getNombreCarroceria() {
        return nombreCarroceria;
    }

    public void setNombreCarroceria(String nombreCarroceria) {
        this.nombreCarroceria = nombreCarroceria;
    }

    public String getDetalleCarroceria() {
        return detalleCarroceria;
    }

    public void setDetalleCarroceria(String detalleCarroceria) {
        this.detalleCarroceria = detalleCarroceria;
    }

    public CarroceriaModel() {
    }

    public CarroceriaModel(String nombreCarroceria, String detalleCarroceria) {
        this.nombreCarroceria = nombreCarroceria;
        this.detalleCarroceria = detalleCarroceria;
    }

    private CarroceriaModel(int idCarroceria, String nombreCarroceria, String detalleCarroceria) {
        this.idCarroceria = idCarroceria;
        this.nombreCarroceria = nombreCarroceria;
        this.detalleCarroceria = detalleCarroceria;
    }

    public boolean nuevaCarroceria(CarroceriaModel nuevaCarroceria) {

        int id = 0;

        if (!carroceria.isEmpty()) {

            for (CarroceriaModel carrocerias : carroceria) {
                if (carrocerias.getIdCarroceria() > id) {
                    id = carrocerias.getIdCarroceria();
                }
            }

        }

        id++;

        carroceria.add(new CarroceriaModel(id, nuevaCarroceria.getNombreCarroceria(), nuevaCarroceria.getDetalleCarroceria()));

        return true;
    }

    public CarroceriaModel buscaCarroceria(int idCarroceriaBuscada) {

        CarroceriaModel carroceriaEncontrado = null;

        if (!carroceria.isEmpty()) {
            for (CarroceriaModel carrocerias : carroceria) {
                if (carrocerias.getIdCarroceria() == idCarroceriaBuscada) {
                    carroceriaEncontrado = carrocerias;
                }
            }
        }

        return carroceriaEncontrado;

    }

    public CarroceriaModel editarCarroceria(int idCarroceria, CarroceriaModel carroceriaEditar) {

        CarroceriaModel carroceriaEditado = null;

        if (!carroceria.isEmpty()) {
            for (CarroceriaModel carrocerias : carroceria) {
                if (carrocerias.getIdCarroceria() == idCarroceria) {
                    carrocerias.setNombreCarroceria(carroceriaEditar.getNombreCarroceria());
                    carrocerias.setDetalleCarroceria(carroceriaEditar.getDetalleCarroceria());

                    carroceriaEditado = carrocerias;
                }
            }
        }

        return carroceriaEditado;

    }

    public boolean eliminarCarrocerias(int id) {
        CarroceriaModel carroceriaEliminado = null;

        if (!carroceria.isEmpty()) {
            for (CarroceriaModel carrocerias : carroceria) {
                if (carrocerias.getIdCarroceria() == idCarroceria) {
                    carroceriaEliminado = carrocerias;
                }
            }
        }

        carroceria.remove(carroceriaEliminado);

        return true;
    }

}
