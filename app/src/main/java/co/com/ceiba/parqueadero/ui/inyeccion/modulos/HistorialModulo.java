package co.com.ceiba.parqueadero.ui.inyeccion.modulos;


import javax.inject.Singleton;

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

    @Provides @Singleton ServicioIngresarVehiculo providesServicioIngresarVehiculo(HistorialDao historialDao){
        return new ServicioIngresarVehiculo(new HistorialImplementacionLocal(historialDao));
    }

    @Provides @Singleton ServicioListarHistorial providesServicioListarHistorial(HistorialDao historialDao){
        return new ServicioListarHistorial(new HistorialImplementacionLocal(historialDao));
    }

    @Provides @Singleton ServicioListarParqueados providesServicioListarParqueados(HistorialDao historialDao){
        return new ServicioListarParqueados(new HistorialImplementacionLocal(historialDao));
    }

    @Provides @Singleton ServicioSalidaVehiculo providesServicioSalidaVehiculo(HistorialDao historialDao){
        return new ServicioSalidaVehiculo(new HistorialImplementacionLocal(historialDao));
    }

}
