package co.com.ceiba.parqueadero.ui.historiales;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import co.com.ceiba.parqueadero.R;

public class HistorialesFragment extends Fragment {

    private HistorialesViewModel historialesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        historialesViewModel =
                ViewModelProviders.of(this).get(HistorialesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_historiales, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        historialesViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}