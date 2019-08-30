package co.com.ceiba.parqueadero.ui.historiales;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HistorialesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HistorialesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(" Este es Historiales fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}