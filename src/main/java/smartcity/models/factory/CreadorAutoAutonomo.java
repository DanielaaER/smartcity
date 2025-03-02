package smartcity.models.factory;

import smartcity.models.clases.AutoAutonomo;
import smartcity.models.clases.BicicletaElectrica;
import smartcity.models.clases.Vehiculo;

// Creadores Concretos
public class CreadorAutoAutonomo extends CreadorVehiculo {
    @Override
    public Vehiculo crearVehiculo() {
        return new AutoAutonomo();
    }
}


