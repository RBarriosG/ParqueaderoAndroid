package co.com.ceiba.parqueadero.dominio.servicio;

import java.util.List;

import co.com.ceiba.parqueadero.dominio.modelo.historial.Historial;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioHistorial;

public class ServicioListarHistorial {

    private RepositorioHistorial repositorioHistorial;

    public ServicioListarHistorial(RepositorioHistorial repositorioHistorial) {
        this.repositorioHistorial = repositorioHistorial;
    }

    public List<Historial> ejecutar(){
        return this.repositorioHistorial.listar();
    }

}
