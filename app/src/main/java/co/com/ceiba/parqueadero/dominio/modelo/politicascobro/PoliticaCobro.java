package co.com.ceiba.parqueadero.dominio.modelo.politicascobro;

import java.time.Duration;
import java.time.LocalDateTime;

import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.TipoVehiculo;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Vehiculo;

public abstract class PoliticaCobro {

    private static final int REGLA_HORA = 9;
    private static final int HORAS_DIA = 24;
    private static final int MILISEGUNDOS_HORA = 1000 * 3600;

    public static PoliticaCobro crear(Vehiculo vehiculo) {
        if (vehiculo.getTipo() == TipoVehiculo.CARRO) {
            return new PoliticaCobroCarro();
        } else {
            return new PoliticaCobroMoto(vehiculo);
        }
    }

    public double calcularCobro(LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
        long totalHoras = calcularTotalHoras(fechaIngreso, fechaSalida);
        long dias = calcularDias(totalHoras);
        long horas = calcularHorasUltimoDia(totalHoras);
        return dias * getValorDia() + horas * getValorHora();
    }

    private long calcularHorasUltimoDia(long totalHoras) {
        long horasExtras = calularTotalHorasExtra(totalHoras);
        return horasExtras < REGLA_HORA ? horasExtras : 0;
    }

    private long calularTotalHorasExtra(long totalHoras) {
        return totalHoras > HORAS_DIA ? totalHoras % HORAS_DIA : totalHoras;
    }

    private long calcularDias(long totalHoras) {
        long totalDias = totalHoras / HORAS_DIA;
        return calularTotalHorasExtra(totalHoras) >= REGLA_HORA ? ++totalDias : totalDias;
    }

    private long calcularTotalHoras(LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
        long milisegundos = Duration.between(fechaIngreso, fechaSalida).toMillis();
        return (long) Math.ceil((double) milisegundos / MILISEGUNDOS_HORA);
    }

    public abstract double getValorDia();

    public abstract double getValorHora();

}
