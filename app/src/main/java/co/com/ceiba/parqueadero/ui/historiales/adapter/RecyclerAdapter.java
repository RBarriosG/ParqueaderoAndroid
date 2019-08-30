package co.com.ceiba.parqueadero.ui.historiales.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.parqueadero.R;
import co.com.ceiba.parqueadero.dominio.modelo.historial.Historial;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {


    Context context;
    LayoutInflater inflater;
    List<Historial> historiales = new ArrayList<>();

    public RecyclerAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(inflater.inflate(R.layout.item_historial, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
