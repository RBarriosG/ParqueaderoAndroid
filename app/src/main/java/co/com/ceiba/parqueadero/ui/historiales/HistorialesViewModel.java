package co.com.ceiba.parqueadero.ui.historiales;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import co.com.ceiba.parqueadero.dominio.modelo.historial.Historial;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioHistorial;
import co.com.ceiba.parqueadero.persistencia.conversor.ConversorHistorial;
import co.com.ceiba.parqueadero.persistencia.entidad.HistorialEntity;

public class HistorialesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    private RepositorioHistorial repositorioHistorial;

    private HistorialEntity historialEntity;

    public HistorialesViewModel(RepositorioHistorial repositorioHistorial) {
        this.repositorioHistorial = repositorioHistorial;
        mText = new MutableLiveData<>();
        mText.setValue(" Este es Historiales fragment");
    }

    public List<Historial> listar() {
        return repositorioHistorial.listar();
    }

    public LiveData<String> getText() {
        return mText;
    }
}