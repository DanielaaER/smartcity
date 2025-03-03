package smartcity.models.clases;

import smartcity.models.factory.CreadorVehiculo;

public class GestionVehiculos {
    private Vehiculo vehiculo;

    public void seleccionarVehiculo(CreadorVehiculo creador) {
        this.vehiculo = creador.crearVehiculo();
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
}