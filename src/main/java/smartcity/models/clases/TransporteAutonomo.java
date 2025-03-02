package smartcity.models.clases;

public class TransporteAutonomo extends Vehiculo {
    public void encender() {
        System.out.println("Transporte autónomo encendido");
        setEstado(ENCENDIDO);
        setVelocidad(0);
    }

    public void apagar() {
        System.out.println("Transporte autónomo apagado");
        setEstado(APAGADO);
        setVelocidad(0);
    }


}
