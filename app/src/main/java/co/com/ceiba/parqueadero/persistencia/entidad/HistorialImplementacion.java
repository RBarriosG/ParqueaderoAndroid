package co.com.ceiba.parqueadero.persistencia.entidad;

import java.util.List;
import java.util.Optional;

import co.com.ceiba.parqueadero.dominio.modelo.historial.Historial;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Parqueo;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.TipoVehiculo;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioHistorial;
import co.com.ceiba.parqueadero.persistencia.conversor.ConversorHistorial;
import co.com.ceiba.parqueadero.persistencia.conversor.ConversorParqueo;

public class HistorialImplementacion implements RepositorioHistorial {

    private final HistorialDao historialDao;

    public HistorialImplementacion(HistorialDao historialDao) {
        this.historialDao = historialDao;
    }

    @Override
    public List<Historial> listar() {
        return ConversorHistorial.convertirADominio(historialDao.listar());
    }

    @Override
    public Historial guardar(Historial historial) {
        return ConversorHistorial.convertirADominio(historialDao.guardar(ConversorHistorial.convertirAEntidad(historial)));
    }

    @Override
    public Historial actualizar(Historial historial) {
        return ConversorHistorial.convertirADominio(historialDao.guardar(ConversorHistorial.convertirAEntidad(historial)));
    }

    @Override
    public List<Parqueo> listarVehiculosEnElParqueadero() {
        return ConversorParqueo.convertirADominio(historialDao.listarVehiculosEnElParqueadero());
    }

    @Override
    public Optional<Historial> obtenerHistorialActualVehiculoParqueado(String placa) {
        HistorialEntity entity = historialDao.obtenerHistorialActualVehiculoParqueado(placa);
        return entity != null ? Optional.of(ConversorHistorial.convertirADominio(entity)) : Optional.empty();
    }

    @Override
    public long contarVehiculosParqueadosPorTipo(TipoVehiculo tipo) {
        return historialDao.contarVehiculosParqueadosPorTipo(tipo);
    }
}
