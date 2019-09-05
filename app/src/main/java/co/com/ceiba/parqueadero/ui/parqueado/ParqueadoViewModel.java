package co.com.ceiba.parqueadero.ui.parqueado;

import androidx.lifecycle.ViewModel;

import java.time.LocalDateTime;
import java.util.List;


import javax.inject.Inject;
import javax.inject.Singleton;

import co.com.ceiba.parqueadero.dominio.modelo.historial.Historial;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Parqueo;
import co.com.ceiba.parqueadero.dominio.servicio.ServicioIngresarVehiculo;
import co.com.ceiba.parqueadero.dominio.servicio.ServicioListarParqueados;
import co.com.ceiba.parqueadero.dominio.servicio.ServicioSalidaVehiculo;
import co.com.ceiba.parqueadero.ui.inyeccion.componentes.ComponenteGeneral;
import co.com.ceiba.parqueadero.ui.inyeccion.componentes.DaggerComponenteGeneral;

public class ParqueadoViewModel extends ViewModel {

    ServicioIngresarVehiculo servicioIngresarVehiculo;
    ServicioSalidaVehiculo servicioSalidaVehiculo;
    ServicioListarParqueados servicioListarParqueados;

    public ParqueadoViewModel() {
        ComponenteGeneral componenteParqueado = DaggerComponenteGeneral.create();

        componenteParqueado.inject(this);
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