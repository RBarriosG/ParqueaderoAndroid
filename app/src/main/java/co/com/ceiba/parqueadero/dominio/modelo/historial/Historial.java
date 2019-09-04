package co.com.ceiba.parqueadero.dominio.modelo.historial;

import java.time.LocalDateTime;

import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Vehiculo;

public class Historial {

    private Vehiculo vehiculo;

    private LocalDateTime fechaIngreso;

    private LocalDateTime fechaSalida;

    private double cobro;

    public Historial(Vehiculo vehiculo, LocalDateTime fechaIngreso, LocalDateTime fechaSalida, double cobro) {
        this.vehiculo = vehiculo;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.cobro = cobro;
    }

    public Historial(Vehiculo vehiculo, LocalDateTime fechaIngreso) {
        this(vehiculo, fechaIngreso, null, 0);
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public double getCobro() {
        return cobro;
    }

    @Override
    public String toString() {
        return "Historial{" +
                "vehiculo=" + vehiculo +
                ", fechaIngreso=" + fechaIngreso +
                ", fechaSalida=" + fechaSalida +
                ", cobro=" + cobro +
                '}';
    }
}
