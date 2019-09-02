package co.com.ceiba.parqueadero.ui.parqueado.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.com.ceiba.parqueadero.R;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Parqueo;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.TipoVehiculo;

public class RecyclerAdapterParqueado extends RecyclerView.Adapter<RecyclerViewHolderParqueado> {

    private static final String CARRO = "CARRO";
    private static final String MOTO = "MOTO";

    private Context context;
    private LayoutInflater inflater;

    private List<Parqueo> parqueados;

    public RecyclerAdapterParqueado(Context context, List<Parqueo> parqueados) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.parqueados = parqueados;
    }


    @NonNull
    @Override
    public RecyclerViewHolderParqueado onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewHolderParqueado(inflater.inflate(R.layout.item_parqueo, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolderParqueado holder, int position) {
        holder.imagenTipoVehiculo.setImageDrawable(
                parqueados.get(position).getVehiculo().getTipo() == TipoVehiculo.CARRO ?
                        context.getDrawable(R.drawable.ic_coche) :
                        context.getDrawable(R.drawable.ic_motocicleta));
        holder.textPlaca.setText(parqueados.get(position).getVehiculo().getPlaca());
        holder.textTipo.setText(parqueados.get(position).getVehiculo().getTipo() == TipoVehiculo.CARRO ? CARRO : MOTO);
        holder.textCilindraje.setText(parqueados.get(position).getVehiculo().getCilindraje());
        holder.textFechaIngreso.setText(String.valueOf(parqueados.get(position).getFechaIngreso()));

        holder.botonSalida.setOnClickListener(view -> salidaVehiculo());
    }

    @Override
    public int getItemCount() {
        return parqueados.size();
    }

    private void salidaVehiculo() {

    }

}
