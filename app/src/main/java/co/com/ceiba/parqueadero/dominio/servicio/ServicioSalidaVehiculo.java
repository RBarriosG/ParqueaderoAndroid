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

    public double ejecutar(String placa, LocalDateTime fechaSalida){
        actualizar(placa, fechaSalida);
        return 0;
    }

    private void actualizar(String placa, LocalDateTime fechaSalida) {
        Historial historial = buscarVehiculoEnHistorial(placa);
        double cobro = calcularCobro(historial, fechaSalida);
        actualizarHistorial(historial, fechaSalida, cobro);
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

    private Historial buscarVehiculoEnHistorial(String placa) {
        List<Parqueo> parqueados = this.repositorioHistorial.listarVehiculosEnElParqueadero();

        for (int i = 0; i < parqueados.size(); i++) {
            if (parqueados.get(i).getVehiculo().getPlaca().equalsIgnoreCase(placa)) {
                return new Historial(parqueados.get(i).getVehiculo(), parqueados.get(i).getFechaIngreso());
            }
        }

        throw new ExcepcionVehiculoNoSeEncuentraEnParqueadero(VEHICULO_NO_ESTA_EN_PARQUEADERO);
    }
}
