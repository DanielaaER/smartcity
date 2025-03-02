package smartcity.models.interfaces;

public interface IEstados {
    public int APAGADO = 0, ENCENDIDO = 1,  EN_MOVIMIENTO = 2, CARGANDO = 3, EN_ESPERA = 4, MANEJO_MANUAL = 5, DESCARGADO = 6;
    public String[] estados = {"Apagado", "Encendido", "En movimiento", "Cargando", "En espera", "Manejo manual", "Descargado"};
}
