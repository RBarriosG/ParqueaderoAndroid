package co.com.ceiba.parqueadero.testdatabuilder;

import java.time.LocalDateTime;

import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Parqueo;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Vehiculo;

public class ParqueoTestDataBuilder {

    private static final Vehiculo VEHICULO_PRUEBA = new VehiculoTestDataBuilder().build();
    private static final LocalDateTime FECHA_INGRESO_PRUEBA = LocalDateTime.of(2019, 8, 28, 7, 0);

    private Vehiculo vehiculo;

    private LocalDateTime fechaIngreso;

    public ParqueoTestDataBuilder() {
        this.vehiculo = VEHICULO_PRUEBA;
        this.fechaIngreso = FECHA_INGRESO_PRUEBA;
    }

    public ParqueoTestDataBuilder conVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
        return this;
    }

    public ParqueoTestDataBuilder conFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public Parqueo build() {
        return new Parqueo(this.vehiculo, this.fechaIngreso);
    }

}
