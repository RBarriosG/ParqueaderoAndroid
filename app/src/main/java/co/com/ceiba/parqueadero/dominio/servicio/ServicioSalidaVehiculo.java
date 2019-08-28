package co.com.ceiba.parqueadero.dominio.servicio;

import java.time.LocalDateTime;
import java.util.List;

import co.com.ceiba.parqueadero.dominio.excepcion.ExcepcionVehiculoNoSeEncuentraEnParqueadero;
import co.com.ceiba.parqueadero.dominio.modelo.historial.Historial;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Parqueo;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Vehiculo;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioHistorial;

public class ServicioSalidaVehiculo {

    private static final String VEHICULO_NO_ESTA_EN_PARQUEADERO = "Vehiculo no está en parqueadero";

    private RepositorioHistorial repositorioHistorial;
    private ServicioCobro servicioCobro;

    public ServicioSalidaVehiculo(RepositorioHistorial repositorioHistorial) {
        this.repositorioHistorial = repositorioHistorial;
        this.servicioCobro = new ServicioCobro();
    }

    public double ejecutar(String placa, LocalDateTime fechaSalida) {
        return actualizar(placa, fechaSalida);
    }

    private double actualizar(String placa, LocalDateTime fechaSalida) {
        Historial historial = repositorioHistorial.obtenerHistorialActualVehiculoParqueado(placa)
                .orElseThrow(() -> new ExcepcionVehiculoNoSeEncuentraEnParqueadero(VEHICULO_NO_ESTA_EN_PARQUEADERO));
        double cobro = calcularCobro(historial, fechaSalida);
        actualizarHistorial(historial, fechaSalida, cobro);
        return cobro;
    }

    private void actualizarHistorial(Historial historial, LocalDateTime fechaSalida, double cobro) {
        Historial historialActualizado = new Historial(historial.getVehiculo(), historial.getFechaIngreso(), fechaSalida, cobro);
        repositorioHistorial.actualizar(historialActualizado);
    }

    private double calcularCobro(Historial historial, LocalDateTime fechaSalida) {
        Vehiculo vehiculo = historial.getVehiculo();
        LocalDateTime fechaIngreso = historial.getFechaIngreso();
        return servicioCobro.calcularCobro(vehiculo, fechaIngreso, fechaSalida);
    }

}
