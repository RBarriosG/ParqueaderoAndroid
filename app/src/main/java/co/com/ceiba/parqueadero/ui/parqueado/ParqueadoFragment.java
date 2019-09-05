package co.com.ceiba.parqueadero.ui.parqueado;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import co.com.ceiba.parqueadero.R;
import co.com.ceiba.parqueadero.dominio.modelo.historial.Historial;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Parqueo;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.TipoVehiculo;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Vehiculo;
import co.com.ceiba.parqueadero.ui.Inicio;
import co.com.ceiba.parqueadero.ui.parqueado.adapter.RecyclerAdapterParqueado;
import co.com.ceiba.parqueadero.ui.parqueado.dialogos.DialogoAgregarParqueo;

public class ParqueadoFragment extends Fragment {

    private Inicio activity;

    private RecyclerView recyclerView;

    private RecyclerAdapterParqueado adapter;

    private EditText editTextPlaca;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_parqueados, container, false);

        activity = (Inicio) getActivity();

        recyclerView = root.findViewById(R.id.recyclerParqueados);

        editTextPlaca = root.findViewById(R.id.editTextPlaca);

        ImageButton imagenBuscar = root.findViewById(R.id.parqueadosImagenBuscar);

        FloatingActionButton fabRefrescar = root.findViewById(R.id.fabRefrescar);

        ExtendedFloatingActionButton efb = root.findViewById(R.id.exFb);

        actualizarRecycler();

        fabRefrescar.setOnClickListener(view -> actualizarRecycler());

        efb.setOnClickListener(view -> guardar());

        imagenBuscar.setOnClickListener(view -> buscar());

        return root;
    }

    private void actualizarRecycler() {
        adapter = new RecyclerAdapterParqueado(activity, activity.listarParqueados());
        adapter.setListaParqueos(activity.listarParqueados());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
    }

    private void guardar() {
        final DialogoAgregarParqueo dialogoAgregarParqueo = new DialogoAgregarParqueo();
        dialogoAgregarParqueo.show(Objects.requireNonNull(getActivity()).getSupportFragmentManager(), "Dialogo Guardar");
        getActivity().getSupportFragmentManager().executePendingTransactions();

        ((AlertDialog) Objects.requireNonNull(dialogoAgregarParqueo.getDialog())).getButton(DialogInterface.BUTTON_POSITIVE)
                .setOnClickListener(view -> {
                    String placa = Objects.requireNonNull(dialogoAgregarParqueo.placaEditText.getText()).toString().toUpperCase().trim();
                    int radioSeleccionado = dialogoAgregarParqueo.radioGrupoTipo.getCheckedRadioButtonId();

                    int cilindraje = Integer.parseInt(Objects.requireNonNull(dialogoAgregarParqueo.cilindrajeEditText.getText()).toString().trim());

                    TipoVehiculo tipo;
                    if (radioSeleccionado == R.id.parqueosRbCarro) {
                        tipo = TipoVehiculo.CARRO;
                    } else {
                        tipo = TipoVehiculo.MOTO;
                    }

                    Vehiculo vehiculo = new Vehiculo(placa, cilindraje, tipo);
                    Historial historial = new Historial(vehiculo, LocalDateTime.now());
                    AsyncTask.execute(() -> activity.parqueadoViewModel.guardar(historial));
                    adapter.setListaParqueos(activity.listarParqueados());
                    dialogoAgregarParqueo.dismiss();
                    adapter.notifyDataSetChanged();
                    Toast.makeText(getContext(), "Vehiculo Agregado al parqueadero: " + placa + " Hora: " + historial.getFechaIngreso(), Toast.LENGTH_SHORT).show();
                });
    }

    private void buscar() {
        String placa = editTextPlaca.getText().toString().trim();
        if (!placa.isEmpty()) {
            List<Parqueo> historialesBuscado = new ArrayList<>();

            //Aqui implementacion para buscar

            adapter.setListaParqueos(historialesBuscado);
        } else {
            Toast.makeText(activity, "No hay datos a buscar", Toast.LENGTH_SHORT).show();
        }
    }

}