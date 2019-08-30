package co.com.ceiba.parqueadero.ui.parqueado;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import co.com.ceiba.parqueadero.R;

public class ParqueadoFragment extends Fragment {

    private ParqueadoViewModel parqueadoViewModel;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        parqueadoViewModel =
                ViewModelProviders.of(this).get(ParqueadoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_parqueados, container, false);

        ExtendedFloatingActionButton efb = root.findViewById(R.id.exFb);

        efb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Vehiculo Agregado al parqueadero", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }
}