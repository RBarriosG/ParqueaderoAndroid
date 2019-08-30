package co.com.ceiba.parqueadero.ui;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioHistorial;
import co.com.ceiba.parqueadero.ui.historiales.HistorialesViewModel;
import co.com.ceiba.parqueadero.ui.parqueado.ParqueadoViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private static final String CLASE_VIEW_MODEL_DESCONOCIDA = "Clase view model desconocida";

    private final RepositorioHistorial repositorioHistorial;

    public ViewModelFactory(RepositorioHistorial repositorioHistorial) {
        this.repositorioHistorial = repositorioHistorial;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HistorialesViewModel.class)) {
            return (T) new HistorialesViewModel(repositorioHistorial);
        } else if (modelClass.isAssignableFrom(ParqueadoViewModel.class)) {
            return (T) new ParqueadoViewModel(repositorioHistorial);
        }
        throw new IllegalArgumentException(CLASE_VIEW_MODEL_DESCONOCIDA);
    }
}
