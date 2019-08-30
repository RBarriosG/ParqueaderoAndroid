package co.com.ceiba.parqueadero.persistencia.entidad;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;

import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Vehiculo;

@Entity(tableName = "historial")
public class HistorialEntity {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private Long id;

    private LocalDateTime fechaIngreso;

    private LocalDateTime fechaSalida;

    @Embedded
    private Vehiculo vehiculo;

    private double cobro;

    public HistorialEntity(){}

    public HistorialEntity(LocalDateTime fechaIngreso, LocalDateTime fechaSalida, Vehiculo vehiculo, double cobro) {
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.vehiculo = vehiculo;
        this.cobro = cobro;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public double getCobro() {
        return cobro;
    }

    public void setCobro(double cobro) {
        this.cobro = cobro;
    }
}
