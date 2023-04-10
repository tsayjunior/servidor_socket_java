/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_socket_marcadores_gas;

import java.io.Serializable;

/**
 *
 * @author hp
 */
public class Gasolinera implements Serializable{
    private double diesel;
    private double gasolinaPlomo;
    private double dieselPlomo;

    public Gasolinera(double diesel, double gasolinaPlomo, double dieselPlomo) {
        this.diesel = diesel;
        this.gasolinaPlomo = gasolinaPlomo;
        this.dieselPlomo = dieselPlomo;
    }

    public double getDiesel() {
        return diesel;
    }

    public void setDiesel(double diesel) {
        this.diesel = diesel;
    }

    public double getGasolinaPlomo() {
        return gasolinaPlomo;
    }

    public void setGasolinaPlomo(double gasolinaPlomo) {
        this.gasolinaPlomo = gasolinaPlomo;
    }

    public double getDieselPlomo() {
        return dieselPlomo;
    }

    public void setDieselPlomo(double dieselPlomo) {
        this.dieselPlomo = dieselPlomo;
    }
    
    
}
