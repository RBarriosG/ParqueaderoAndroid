package co.com.ceiba.parqueadero.dominio.modelo.vehiculo;

import java.time.LocalDateTime;

public class Parqueo {

    private Vehiculo vehiculo;
    private LocalDateTime fechaIngreso;

    public Parqueo(Vehiculo vehiculo, LocalDateTime fechaIngreso) {
        this.vehiculo = vehiculo;
        this.fechaIngreso = fechaIngreso;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }
}
