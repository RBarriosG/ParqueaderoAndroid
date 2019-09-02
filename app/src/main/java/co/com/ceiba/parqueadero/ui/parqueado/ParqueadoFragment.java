package co.com.ceiba.parqueadero.ui.parqueado;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.parqueadero.Injection;
import co.com.ceiba.parqueadero.R;
import co.com.ceiba.parqueadero.dominio.modelo.historial.Historial;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Parqueo;
import co.com.ceiba.parqueadero.ui.ViewModelFactory;
import co.com.ceiba.parqueadero.ui.parqueado.adapter.RecyclerAdapterParqueado;

public class ParqueadoFragment extends Fragment {

    private ViewModelFactory viewModelFactory;

    private ParqueadoViewModel parqueadoViewModel;

    private RecyclerView recyclerView;

    private List<Parqueo> parqueos = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModelFactory = Injection.provideViewModelFactory(getContext());
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        parqueadoViewModel = new ViewModelProvider(this, viewModelFactory).get(ParqueadoViewModel.class);

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                parqueos = parqueadoViewModel.listarParqueados();
            }
        });


        View root = inflater.inflate(R.layout.fragment_parqueados, container, false);

        actualizarRecycler(parqueos, root);

        ExtendedFloatingActionButton efb = root.findViewById(R.id.exFb);

        efb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Vehiculo Agregado al parqueadero", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    private void actualizarRecycler(List<Parqueo> parqueos, View view) {
        RecyclerAdapterParqueado adapter = new RecyclerAdapterParqueado(getContext(), parqueos);
        recyclerView = view.findViewById(R.id.recyclerParqueados);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.notifyDataSetChanged();
    }

    public void guardar(Historial parqueo) {

    }

}