package co.com.ceiba.parqueadero.ui;

import co.com.ceiba.parqueadero.dominio.servicio.ServicioIngresarVehiculo;
import co.com.ceiba.parqueadero.dominio.servicio.ServicioListarHistorial;
import co.com.ceiba.parqueadero.dominio.servicio.ServicioListarParqueados;
import co.com.ceiba.parqueadero.dominio.servicio.ServicioSalidaVehiculo;
import co.com.ceiba.parqueadero.persistencia.entidad.HistorialDao;
import co.com.ceiba.parqueadero.persistencia.entidad.HistorialImplementacionLocal;
import dagger.Module;
import dagger.Provides;

@Module
public class HistorialModulo {

    @Provides
    public ServicioIngresarVehiculo servicioIngresarVehiculo(HistorialDao historialDao){
        return new ServicioIngresarVehiculo(new HistorialImplementacionLocal(historialDao));
    }

    @Provides
    public ServicioListarHistorial servicioListarHistorial(HistorialDao historialDao){
        return new ServicioListarHistorial(new HistorialImplementacionLocal(historialDao));
    }

    @Provides
    public ServicioListarParqueados servicioListarParqueados(HistorialDao historialDao){
        return new ServicioListarParqueados(new HistorialImplementacionLocal(historialDao));
    }

    @Provides
    public ServicioSalidaVehiculo servicioSalidaVehiculo(HistorialDao historialDao){
        return new ServicioSalidaVehiculo(new HistorialImplementacionLocal(historialDao));
    }

}
