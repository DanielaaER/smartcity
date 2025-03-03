package smartcity;

import smartcity.controllers.ControladorVehiculo;
import smartcity.models.clases.GestionVehiculos;
import smartcity.view.VistaVehiculo;

public class Main {
    public static void main(String[] args) {
//        System.out.println("SMART CITY");
//        Vehiculo auto = new AutoAutonomo();
//        Vehiculo transporte = new TransporteAutonomo();
//        Vehiculo sensor = new BicicletaElectrica();
//
//        auto.encender();
//
//        auto.getEstado();
//
//        System.out.println("Auto en movimiento");
//        auto.acelerar();
//        auto.frenar();
//        System.out.println("Auto en espera");
//
//        auto.getEstado();
//        auto.apagar();

        GestionVehiculos gestionVehiculos = new GestionVehiculos();
        VistaVehiculo vista = new VistaVehiculo();
        new ControladorVehiculo(gestionVehiculos, vista);
    }
}