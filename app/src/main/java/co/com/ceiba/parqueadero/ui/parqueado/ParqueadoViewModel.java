package co.com.ceiba.parqueadero.ui.parqueado;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioHistorial;

public class ParqueadoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    private RepositorioHistorial repositorioHistorial;

    public ParqueadoViewModel(RepositorioHistorial repositorioHistorial) {
        mText = new MutableLiveData<>();
        mText.setValue(" Este es parqueados Fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}