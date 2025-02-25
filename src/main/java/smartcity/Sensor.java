package smartcity;

public class Sensor implements IEstados{

    private int nivelBateria;
    private int estado;

    private int velocidad;

    public Sensor(){
        this.nivelBateria = 100;
        this.estado = IEstados.APAGADO;
        this.velocidad = 0;
    }

    public void setEstado(int estado){
        this.estado = estado;
    }

    public int getEstado(){
        return this.estado;
    }

    public int getBateria(){
        System.out.println("Nivel de bateria: " + this.nivelBateria);
        return this.nivelBateria;
    }

    public void cargarBateria(){
        this.nivelBateria = 100;
        this.estado = IEstados.CARGANDO;
    }

    public void setBateria(int bateria){
        this.nivelBateria = bateria;
    }

    public void setVelocidad(int velocidad){
        this.velocidad = velocidad;
    }

    public int getVelocidad(){
        return this.velocidad;
    }



}
