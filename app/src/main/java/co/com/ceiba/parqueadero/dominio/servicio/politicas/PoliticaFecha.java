package co.com.ceiba.parqueadero.dominio.servicio.politicas;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class PoliticaFecha {

    public boolean esDiaHabil(LocalDateTime fechaIngreso) {
        return !esLunes(fechaIngreso) && !esDomingo(fechaIngreso);
    }

    private boolean esDomingo(LocalDateTime fechaIngreso) {
        return fechaIngreso.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    private boolean esLunes(LocalDateTime fechaIngreso) {
        return fechaIngreso.getDayOfWeek() == DayOfWeek.MONDAY;
    }

}
