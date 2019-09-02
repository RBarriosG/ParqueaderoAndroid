package co.com.ceiba.parqueadero.ui.parqueado;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import co.com.ceiba.parqueadero.Injection;
import co.com.ceiba.parqueadero.R;
import co.com.ceiba.parqueadero.dominio.modelo.historial.Historial;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Parqueo;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.TipoVehiculo;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Vehiculo;
import co.com.ceiba.parqueadero.ui.ViewModelFactory;
import co.com.ceiba.parqueadero.ui.parqueado.adapter.RecyclerAdapterParqueado;
import co.com.ceiba.parqueadero.ui.parqueado.dialogos.DialogoAgregarParqueo;

public class ParqueadoFragment extends Fragment {

    private ViewModelFactory viewModelFactory;

    private ParqueadoViewModel parqueadoViewModel;

    private List<Parqueo> parqueos = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModelFactory = Injection.provideViewModelFactory(getContext());
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        parqueadoViewModel = new ViewModelProvider(this, viewModelFactory).get(ParqueadoViewModel.class);

        AsyncTask.execute(() -> parqueos = parqueadoViewModel.listarParqueados());


        View root = inflater.inflate(R.layout.fragment_parqueados, container, false);

        actualizarRecycler(parqueos, root);

        ExtendedFloatingActionButton efb = root.findViewById(R.id.exFb);

        efb.setOnClickListener(view -> {
            guardar();
            actualizarRecycler(parqueos, root);
        });

        return root;
    }

    private void actualizarRecycler(List<Parqueo> parqueos, View view) {
        RecyclerAdapterParqueado adapter = new RecyclerAdapterParqueado(getContext(), parqueos);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerParqueados);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.notifyDataSetChanged();
    }

    private void guardar() {
        final DialogoAgregarParqueo dialogoAgregarParqueo = new DialogoAgregarParqueo();
        dialogoAgregarParqueo.show(Objects.requireNonNull(getActivity()).getSupportFragmentManager(), "Dialogo Guardar");
        getActivity().getSupportFragmentManager().executePendingTransactions();

        ((AlertDialog) Objects.requireNonNull(dialogoAgregarParqueo.getDialog())).getButton(DialogInterface.BUTTON_POSITIVE)
                .setOnClickListener(view -> {
                    String placa = Objects.requireNonNull(dialogoAgregarParqueo.placaEditText.getText()).toString().trim();
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
                    AsyncTask.execute(() -> parqueadoViewModel.guardar(historial));
                    dialogoAgregarParqueo.dismiss();
                    Toast.makeText(getContext(), "Vehiculo Agregado al parqueadero: " + placa + " Hora: " + historial.getFechaIngreso(), Toast.LENGTH_SHORT).show();
                });
    }

}