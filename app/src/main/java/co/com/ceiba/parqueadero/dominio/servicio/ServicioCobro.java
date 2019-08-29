package co.com.ceiba.parqueadero.dominio.servicio;

import java.time.LocalDateTime;

import co.com.ceiba.parqueadero.dominio.modelo.politicascobro.PoliticaCobro;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Vehiculo;

public class ServicioCobro {

    public double calcularCobro(Vehiculo vehiculo, LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
        PoliticaCobro politicaCobro = PoliticaCobro.crear(vehiculo);
        return politicaCobro.calcularCobro(fechaIngreso, fechaSalida);
    }

}
