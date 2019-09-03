package co.com.ceiba.parqueadero.ui.historiales.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.com.ceiba.parqueadero.R;
import co.com.ceiba.parqueadero.dominio.modelo.historial.Historial;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.TipoVehiculo;
import co.com.ceiba.parqueadero.persistencia.conversor.ConversorLocalDateTime;

public class RecyclerAdapterHistoriales extends RecyclerView.Adapter<RecyclerViewHolderHistoriales> {

    private static final String CARRO = "CARRO";
    private static final String MOTO = "MOTO";

    private Context context;
    private LayoutInflater inflater;

    private List<Historial> historiales;

    public RecyclerAdapterHistoriales(Context context, List<Historial> historiales) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.historiales = historiales;
    }

    @NonNull
    @Override
    public RecyclerViewHolderHistoriales onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewHolderHistoriales(inflater.inflate(R.layout.item_historial, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolderHistoriales holder, int position) {
        holder.imagenTipoVehiculo.setImageDrawable(
                historiales.get(position).getVehiculo().getTipo() == TipoVehiculo.CARRO ?
                        context.getDrawable(R.drawable.ic_coche) :
                        context.getDrawable(R.drawable.ic_motocicleta));
        holder.textPlaca.setText(historiales.get(position).getVehiculo().getPlaca());
        holder.textTipo.setText(historiales.get(position).getVehiculo().getTipo() == TipoVehiculo.CARRO ? CARRO : MOTO);
        holder.textCilindraje.setText(String.valueOf(historiales.get(position).getVehiculo().getCilindraje()));
        holder.textFechaIngreso.setText(ConversorLocalDateTime.aString(historiales.get(position).getFechaIngreso()));
        holder.textFechaSalida.setText(String.valueOf(historiales.get(position).getFechaSalida()));
        holder.textCosto.setText(String.format("$ %s", historiales.get(position).getCobro()));
    }

    @Override
    public int getItemCount() {
        return historiales.size();
    }
}
