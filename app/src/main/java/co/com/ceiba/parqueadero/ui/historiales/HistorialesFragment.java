package co.com.ceiba.parqueadero.ui.historiales;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.parqueadero.Injection;
import co.com.ceiba.parqueadero.R;

import co.com.ceiba.parqueadero.dominio.modelo.historial.Historial;
import co.com.ceiba.parqueadero.ui.ViewModelFactory;
import co.com.ceiba.parqueadero.ui.historiales.adapter.RecyclerAdapterHistoriales;

public class HistorialesFragment extends Fragment {

    private ViewModelFactory viewModelFactory;

    private HistorialesViewModel historialesViewModel;

    private List<Historial> historiales = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModelFactory = Injection.provideViewModelFactory(getContext());
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        historialesViewModel = new ViewModelProvider(this, viewModelFactory).get(HistorialesViewModel.class);

        AsyncTask.execute(() -> historiales = historialesViewModel.listar());

        View root = inflater.inflate(R.layout.fragment_historiales, container, false);
        actualizarRecycler(historiales, root);
        return root;
    }

    private void actualizarRecycler(List<Historial> historiales, View view){
        RecyclerAdapterHistoriales adapter = new RecyclerAdapterHistoriales(getContext(), historiales);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerHistoriales);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.notifyDataSetChanged();
    }

}