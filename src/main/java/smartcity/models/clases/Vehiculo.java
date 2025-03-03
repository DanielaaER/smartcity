package smartcity.models.clases;

import smartcity.models.interfaces.IEncendible;
import smartcity.models.interfaces.IEstados;
import smartcity.models.interfaces.IMovible;

public abstract class Vehiculo implements IEncendible, IMovible, IEstados {
    private Sensor sensor;

    Vehiculo() {
        sensor = new Sensor();
        setEstado(APAGADO);
    }

    public void encender() {
        setEstado(ENCENDIDO);
        setVelocidad(10);
    }

    public void apagar() {
        setEstado(APAGADO);
        setVelocidad(0);
    }

    public String mover() {
        String state = "";
        if (getEstado() == APAGADO) {
            System.out.println("El vehículo está apagado");
            state = "El vehículo está apagado";
            if (getBateria() <= 0) {
                System.out.println("La batería está agotada");
                state = "La batería está agotada";
            }
            setEstado(APAGADO);
        } else if (getEstado() == CARGANDO) {
            System.out.println("El vehículo está cargando");
            state = "El vehículo está cargando";
            setEstado(CARGANDO);
        } else {
            setVelocidad(10);
            System.out.println(getBateria());
            setBateria(getBateria() - 5);
            System.out.println(getBateria());
            state = "El vehículo está en movimiento";
            setEstado(EN_MOVIMIENTO);
        }
        return state;
    }


    public void acelerar() {
        System.out.println("get estado: " + getEstado());
        if (getEstado() == EN_MOVIMIENTO) {
            setVelocidad(getVelocidad() + 10);
            setBateria(getBateria() - 10);
            System.out.println("bateria: " + getBateria());
        }
    }
    public void desacelerar() {
        setVelocidad(getVelocidad() - 10);
    }

    public void frenar() {
        setVelocidad(0);
        setEstado(EN_ESPERA);
    }


    // Wrapper methods for Sensor
    public Sensor getSensor() {
        return sensor;
    }

    public int getEstado() {
        return sensor.getEstado();
    }

    public void setEstado(int estado) {
        sensor.setEstado(estado);
    }

    public int getBateria() {
        return sensor.getBateria();
    }

    public void cargarBateria() {
        sensor.cargarBateria();
    }

    public void setBateria(int bateria) {
        sensor.setBateria(bateria);
    }


    public int getVelocidad() {
        return sensor.getVelocidad();
    }

    public void setVelocidad(int velocidad) {
        sensor.setVelocidad(velocidad);
    }


}
