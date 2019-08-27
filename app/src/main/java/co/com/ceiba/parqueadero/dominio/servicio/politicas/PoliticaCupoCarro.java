package co.com.ceiba.parqueadero.dominio.servicio.politicas;

import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.TipoVehiculo;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioHistorial;

public class PoliticaCupoCarro {

    private static final int MAXIMO_CUPO_CARRO = 20;
    private RepositorioHistorial repositorioHistorial;

    public PoliticaCupoCarro(RepositorioHistorial repositorioHistorial) {
        this.repositorioHistorial = repositorioHistorial;
    }

    public boolean validar(){
        long carrosParqueados = repositorioHistorial.contarVehiculosParqueadosPorTipo(TipoVehiculo.CARRO);
        return carrosParqueados < MAXIMO_CUPO_CARRO;
    }
}
