package co.com.ceiba.parqueadero.ui.parqueado;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ParqueadoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ParqueadoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(" Este es parqueados Fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}