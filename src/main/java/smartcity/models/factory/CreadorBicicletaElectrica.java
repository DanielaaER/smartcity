package smartcity.models.factory;

import smartcity.models.clases.BicicletaElectrica;
import smartcity.models.clases.Vehiculo;

public class CreadorBicicletaElectrica extends CreadorVehiculo {
    @Override
    public Vehiculo crearVehiculo() {
        return new BicicletaElectrica();
    }
}
