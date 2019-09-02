package co.com.ceiba.parqueadero.dominio.servicio;

import java.time.LocalDateTime;

import co.com.ceiba.parqueadero.dominio.modelo.historial.Historial;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Vehiculo;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioHistorial;
import co.com.ceiba.parqueadero.dominio.servicio.politicas.PoliticaIngresoVehiculo;

public class ServicioIngresarVehiculo {

    private final RepositorioHistorial repositorioHistorial;
    private final PoliticaIngresoVehiculo politicaIngresoVehiculo;

    public ServicioIngresarVehiculo(RepositorioHistorial repositorioHistorial) {
        this.repositorioHistorial = repositorioHistorial;
        this.politicaIngresoVehiculo = new PoliticaIngresoVehiculo(repositorioHistorial);
    }

    public co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Parqueo ejecutar(Vehiculo vehiculo, LocalDateTime fechaIngreso) {
        politicaIngresoVehiculo.validar(vehiculo, fechaIngreso);
        return almacenarEnHistorial(vehiculo, fechaIngreso);
    }

    private co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Parqueo almacenarEnHistorial(Vehiculo vehiculo, LocalDateTime fechaIngreso) {
        Historial historial = repositorioHistorial.guardar(new Historial(vehiculo, fechaIngreso));
        return new co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Parqueo(historial.getVehiculo(), historial.getFechaIngreso());
    }

}
