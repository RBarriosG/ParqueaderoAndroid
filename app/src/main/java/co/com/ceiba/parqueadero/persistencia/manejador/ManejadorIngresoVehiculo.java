package co.com.ceiba.parqueadero.persistencia.manejador;

import java.time.LocalDateTime;

import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Vehiculo;
import co.com.ceiba.parqueadero.dominio.servicio.ServicioIngresarVehiculo;

public class ManejadorIngresoVehiculo {

    private ServicioIngresarVehiculo servicioIngresarVehiculo;

    public ManejadorIngresoVehiculo(ServicioIngresarVehiculo servicioIngresarVehiculo) {
        this.servicioIngresarVehiculo = servicioIngresarVehiculo;
    }

    public void ejecutar(Vehiculo vehiculo){
        this.servicioIngresarVehiculo.ejecutar(vehiculo, LocalDateTime.now());
    }

}
