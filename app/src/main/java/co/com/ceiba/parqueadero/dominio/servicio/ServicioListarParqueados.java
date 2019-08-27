package co.com.ceiba.parqueadero.dominio.servicio;

import java.util.List;

import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Parqueo;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioHistorial;

public class ServicioListarParqueados {

    private RepositorioHistorial repositorioHistorial;

    public ServicioListarParqueados(RepositorioHistorial repositorioHistorial) {
        this.repositorioHistorial = repositorioHistorial;
    }

    public List<Parqueo> ejecutar(){
        return this.repositorioHistorial.listarVehiculosEnElParqueadero();
    }

}
