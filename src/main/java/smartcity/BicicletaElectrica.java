package smartcity;

public class BicicletaElectrica extends Vehiculo {
    private boolean modoManual;


    public void setModoManual(boolean modoManual) {
        System.out.println("Modo manual: " + modoManual);
        this.modoManual = modoManual;
        if (modoManual) {
            setEstado(MANEJO_MANUAL);
        } else {
            setEstado(EN_MOVIMIENTO);
        }
    }


    // si no es manual llamas a super
    public void mover() {
            setEstado(EN_MOVIMIENTO);
            System.out.println("Modo manual activado");
            cargarBateria();

    }

    // si no es manual llamas a super
    public void acelerar() {
            setVelocidad(getVelocidad() + 10);
            setBateria(getBateria() + 10);

            super.acelerar();



    }

    public void encender() {
        System.out.println("Bicicleta encendida");
        setEstado(ENCENDIDO);
        setVelocidad(0);
    }

    public void apagar() {
        System.out.println("Bicicleta apagada");
        setVelocidad(0);
        setEstado(APAGADO);
    }


}
