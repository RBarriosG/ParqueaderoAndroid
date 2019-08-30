package co.com.ceiba.parqueadero.persistencia.conversor;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Parqueo;
import co.com.ceiba.parqueadero.persistencia.entidad.HistorialEntity;

public class ConversorParqueo {

    private ConversorParqueo() {
    }

    public static List<Parqueo> convertirADominio(List<HistorialEntity> historialEntities) {
        List<Parqueo> parqueados = new ArrayList<>();
        for (int i = 0; i < historialEntities.size(); i++) {
            parqueados.add(new Parqueo(historialEntities.get(i).getVehiculo(), historialEntities.get(i).getFechaIngreso()));
        }
        return parqueados;
    }

}
