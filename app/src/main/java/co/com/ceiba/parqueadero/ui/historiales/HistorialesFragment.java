package co.com.ceiba.parqueadero.ui.historiales;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import co.com.ceiba.parqueadero.R;

import co.com.ceiba.parqueadero.ui.InicioActivity;
import co.com.ceiba.parqueadero.ui.historiales.adapter.RecyclerAdapterHistoriales;

public class HistorialesFragment extends Fragment {

    private RecyclerView recyclerView;

    private RecyclerAdapterHistoriales adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(adapter != null)
            adapter.notifyDataSetChanged();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_historiales, container, false);

        recyclerView = root.findViewById(R.id.recyclerHistoriales);
        actualizarRecycler();

        FloatingActionButton fabRefrescar = root.findViewById(R.id.historialesFabRefrescar);

        fabRefrescar.setOnClickListener(view -> actualizarRecycler());

        return root;
    }

    private void actualizarRecycler(){
        //adapter = new RecyclerAdapterHistoriales(activity, activity.listarHistoriales());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.notifyDataSetChanged();
    }

}