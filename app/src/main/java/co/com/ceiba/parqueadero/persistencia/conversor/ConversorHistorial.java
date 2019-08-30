package co.com.ceiba.parqueadero.persistencia.conversor;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.parqueadero.dominio.modelo.historial.Historial;
import co.com.ceiba.parqueadero.persistencia.entidad.HistorialEntity;

public class ConversorHistorial {

    private ConversorHistorial() {
    }

    public static HistorialEntity convertirAEntidad(Historial historial) {
        return new HistorialEntity(historial.getFechaIngreso(), historial.getFechaSalida(), historial.getVehiculo(), historial.getCobro());
    }

    public static Historial convertirADominio(HistorialEntity historialEntity) {
        return new Historial(historialEntity.getVehiculo(), historialEntity.getFechaIngreso(), historialEntity.getFechaSalida(), historialEntity.getCobro());
    }

    public static List<Historial> convertirADominio(List<HistorialEntity> historialEntities) {
        List<Historial> historiales = new ArrayList<>();
        for (int i = 0; i < historialEntities.size(); i++) {
            historiales.add(convertirADominio(historialEntities.get(i)));
        }
        return historiales;
    }

}
