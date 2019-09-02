package co.com.ceiba.parqueadero.persistencia.conversor;

import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Vehiculo;
import co.com.ceiba.parqueadero.persistencia.entidad.VehiculoMap;

public class ConversorVehiculo {

    private ConversorVehiculo() {
    }

    public static Vehiculo aVehiculo(VehiculoMap vehiculoMap) {
        return vehiculoMap == null ? null : new Vehiculo(vehiculoMap.getPlaca(),
                vehiculoMap.getCilindraje(), ConversorTipoVehiculo.aTipoVehiculo(vehiculoMap.getTipo()));
    }

    public static VehiculoMap aVehiculoMap(Vehiculo vehiculo) {
        return vehiculo == null ? null : new VehiculoMap(vehiculo.getPlaca(), vehiculo.getCilindraje(),
                ConversorTipoVehiculo.aString(vehiculo.getTipo()));
    }

}
