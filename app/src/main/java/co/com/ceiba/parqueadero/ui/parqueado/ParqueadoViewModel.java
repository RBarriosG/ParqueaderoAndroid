package co.com.ceiba.parqueadero.ui.parqueado;

import androidx.lifecycle.ViewModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import co.com.ceiba.parqueadero.dominio.modelo.historial.Historial;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Parqueo;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.TipoVehiculo;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioHistorial;
import co.com.ceiba.parqueadero.dominio.servicio.ServicioIngresarVehiculo;
import co.com.ceiba.parqueadero.dominio.servicio.ServicioListarParqueados;
import co.com.ceiba.parqueadero.dominio.servicio.ServicioSalidaVehiculo;
import co.com.ceiba.parqueadero.persistencia.manejador.ManejadorIngresoVehiculo;

public class ParqueadoViewModel extends ViewModel {

    private ServicioIngresarVehiculo servicioIngresarVehiculo;
    private ServicioSalidaVehiculo servicioSalidaVehiculo;
    private ServicioListarParqueados servicioListarParqueados;

    public ParqueadoViewModel(ServicioIngresarVehiculo servicioIngresarVehiculo, ServicioSalidaVehiculo servicioSalidaVehiculo, ServicioListarParqueados servicioListarParqueados) {
        this.servicioIngresarVehiculo = servicioIngresarVehiculo;
        this.servicioSalidaVehiculo = servicioSalidaVehiculo;
        this.servicioListarParqueados = servicioListarParqueados;
    }

    public List<Parqueo> listarParqueados(){
        return servicioListarParqueados.ejecutar();
    }

    public Parqueo guardar(Historial historial){
        return servicioIngresarVehiculo.ejecutar(historial.getVehiculo(), LocalDateTime.now());
    }

    public double actualizar(Historial historial){
        return  servicioSalidaVehiculo.ejecutar(historial.getVehiculo().getPlaca(), LocalDateTime.now());
    }



    /*public Optional<Historial> obtenerHistorialActualVehiculoParqueado(String placa){
        return repositorioHistorial.obtenerHistorialActualVehiculoParqueado(placa);
    }

    public long contarVehiculosParqueadosPorTipo(TipoVehiculo tipoVehiculo){
        return repositorioHistorial.contarVehiculosParqueadosPorTipo(tipoVehiculo);
    }*/

}