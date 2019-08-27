package co.com.ceiba.parqueadero.dominio.excepcion;

public class ExcepcionIngresoPlacaVehiculo extends RuntimeException {

    public ExcepcionIngresoPlacaVehiculo(String mensaje) {
        super(mensaje);
    }
}
