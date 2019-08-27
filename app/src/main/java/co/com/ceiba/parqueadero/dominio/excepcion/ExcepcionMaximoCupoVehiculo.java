package co.com.ceiba.parqueadero.dominio.excepcion;

public class ExcepcionMaximoCupoVehiculo extends RuntimeException {
    public ExcepcionMaximoCupoVehiculo(String mensaje) {
        super(mensaje);
    }
}
