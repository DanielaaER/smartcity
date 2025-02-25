package smartcity;

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
    }

    public void mover() {
        if (getEstado() == APAGADO) {
            System.out.println("El vehículo está apagado");
        } else if (getBateria() <= 0) {
            System.out.println("La batería está agotada");
        } else if (getEstado() == CARGANDO) {
            System.out.println("El vehículo está cargando");
        } else {
            setVelocidad(10);
            setBateria(getBateria() - 10);
        }
        setEstado(EN_MOVIMIENTO);
    }

    public void enEspera() {
        setEstado(EN_ESPERA);
        setVelocidad(0);
    }

    public void acelerar() {
        setVelocidad(getVelocidad() + 10);
        setBateria(getBateria() - 10);

    }

    public void frenar() {
        setVelocidad(getVelocidad() - 10);
    }


    // Wrapper methods for Sensor
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
