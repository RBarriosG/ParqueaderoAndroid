package co.com.ceiba.parqueadero.dominio.excepcion;

public class ExcepcionVehiculoYaEstaEnParqueadero extends RuntimeException {

    public ExcepcionVehiculoYaEstaEnParqueadero(String mensaje) {
        super(mensaje);
    }
}
