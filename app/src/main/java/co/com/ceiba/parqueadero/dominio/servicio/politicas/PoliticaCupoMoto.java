package co.com.ceiba.parqueadero.dominio.servicio.politicas;

import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.TipoVehiculo;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioHistorial;

public class PoliticaCupoMoto {

    private static final int MAXIMO_CUPO_MOTO = 10;
    private RepositorioHistorial repositorioHistorial;

    public PoliticaCupoMoto(RepositorioHistorial repositorioHistorial) {
        this.repositorioHistorial = repositorioHistorial;
    }

    public boolean validar() {
        long motosParqueadas = repositorioHistorial.contarVehiculosParqueadosPorTipo(TipoVehiculo.MOTO);
        return motosParqueadas < MAXIMO_CUPO_MOTO;
    }
}
