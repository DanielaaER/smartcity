package smartcity.models.factory;

import smartcity.models.clases.TransporteAutonomo;
import smartcity.models.clases.Vehiculo;

public class CreadorTransporteAutonomo extends CreadorVehiculo {
    @Override
    public Vehiculo crearVehiculo() {
        return new TransporteAutonomo();
    }
}
