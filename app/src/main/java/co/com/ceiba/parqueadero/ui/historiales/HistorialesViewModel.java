package co.com.ceiba.parqueadero.ui.historiales;

import androidx.lifecycle.ViewModel;

import java.util.List;

import co.com.ceiba.parqueadero.dominio.modelo.historial.Historial;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioHistorial;

public class HistorialesViewModel extends ViewModel {

    private RepositorioHistorial repositorioHistorial;

    public HistorialesViewModel(RepositorioHistorial repositorioHistorial) {
        this.repositorioHistorial = repositorioHistorial;
    }

    List<Historial> listar() {
        return repositorioHistorial.listar();
    }

}