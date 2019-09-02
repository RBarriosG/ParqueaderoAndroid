package co.com.ceiba.parqueadero.ui.parqueado.dialogos;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;


import co.com.ceiba.parqueadero.R;

public class DialogoAgregarParqueo extends DialogFragment {

    private View dialogView;



    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getContext());

        dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialogo_agregar_parqueo, null);

        builder.setView(dialogView);

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        builder.setPositiveButton("Guardar", null);

        return builder.create();

    }
}
