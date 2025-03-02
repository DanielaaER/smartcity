package smartcity.models.clases;

import smartcity.models.interfaces.IEstados;

public class Sensor implements IEstados {
    private int nivelBateria;
    private int estado;
    private int velocidad;

    public Sensor() {
        this.nivelBateria = 100;
        this.estado = IEstados.APAGADO;
        this.velocidad = 0;
    }

    public int getBateria() {
        return nivelBateria;
    }

    public void setBateria(int nivelBateria) {
        this.nivelBateria = nivelBateria;
    }

    public void cargarBateria(){
        this.nivelBateria = 100;
        this.estado = IEstados.CARGANDO;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void actualizarEstado() {
        if (nivelBateria < 10) {
            estado = IEstados.APAGADO;
        }
    }
}
