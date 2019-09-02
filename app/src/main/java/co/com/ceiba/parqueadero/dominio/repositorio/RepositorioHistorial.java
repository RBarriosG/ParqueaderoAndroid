package co.com.ceiba.parqueadero.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import co.com.ceiba.parqueadero.dominio.modelo.historial.Historial;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Parqueo;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.TipoVehiculo;

public interface RepositorioHistorial {

    List<Historial> listar();

    Historial guardar(Historial historial);

    Historial actualizar(Historial historial);

    List<Parqueo>listarVehiculosEnElParqueadero();

    Optional<Historial> obtenerHistorialActualVehiculoParqueado(String placa);

    long contarVehiculosParqueadosPorTipo(TipoVehiculo tipo);

}
