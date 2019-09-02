package co.com.ceiba.parqueadero.ui.parqueado;

import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.Optional;

import co.com.ceiba.parqueadero.dominio.modelo.historial.Historial;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Parqueo;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.TipoVehiculo;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioHistorial;

public class ParqueadoViewModel extends ViewModel {


    private RepositorioHistorial repositorioHistorial;

    public ParqueadoViewModel(RepositorioHistorial repositorioHistorial) {
        this.repositorioHistorial = repositorioHistorial;
    }

    public List<Parqueo> listarParqueados(){
        return repositorioHistorial.listarVehiculosEnElParqueadero();
    }

    public Historial guardar(Historial historial){
        return repositorioHistorial.guardar(historial);
    }

    public Historial actualizar(Historial historial){
        return  repositorioHistorial.actualizar(historial);
    }

    public Optional<Historial> obtenerHistorialActualVehiculoParqueado(String placa){
        return repositorioHistorial.obtenerHistorialActualVehiculoParqueado(placa);
    }

    public long contarVehiculosParqueadosPorTipo(TipoVehiculo tipoVehiculo){
        return repositorioHistorial.contarVehiculosParqueadosPorTipo(tipoVehiculo);
    }

}