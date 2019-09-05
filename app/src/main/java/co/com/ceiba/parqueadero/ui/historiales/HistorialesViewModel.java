package co.com.ceiba.parqueadero.ui.historiales;

import androidx.lifecycle.ViewModel;

import java.util.List;

import co.com.ceiba.parqueadero.dominio.modelo.historial.Historial;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioHistorial;
import co.com.ceiba.parqueadero.dominio.servicio.ServicioListarHistorial;

public class HistorialesViewModel extends ViewModel {

    private ServicioListarHistorial servicioListarHistorial;

    public HistorialesViewModel(ServicioListarHistorial servicioListarHistorial) {
        this.servicioListarHistorial = servicioListarHistorial;
    }

    public List<Historial> listar() {
        return servicioListarHistorial.ejecutar();
    }

}