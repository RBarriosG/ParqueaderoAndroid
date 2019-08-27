package co.com.ceiba.parqueadero.dominio.excepcion;

public class ExcepcionVehiculoNoSeEncuentraEnParqueadero extends RuntimeException {
    public ExcepcionVehiculoNoSeEncuentraEnParqueadero(String mensaje) {
        super(mensaje);
    }
}
