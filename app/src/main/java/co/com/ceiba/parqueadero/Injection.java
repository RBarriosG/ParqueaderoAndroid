package co.com.ceiba.parqueadero;

import android.content.Context;

import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioHistorial;
import co.com.ceiba.parqueadero.persistencia.BaseDeDatosParqueadero;
import co.com.ceiba.parqueadero.persistencia.entidad.HistorialImplementacionLocal;
import co.com.ceiba.parqueadero.ui.ViewModelFactory;

public class Injection {

    public static RepositorioHistorial provideRepositorioHistorial(Context context){
        BaseDeDatosParqueadero baseDeDatosParqueadero = BaseDeDatosParqueadero.getInstance(context);
        return new HistorialImplementacionLocal(baseDeDatosParqueadero.historialDao());
    }

    public static ViewModelFactory provideViewModelFactory(Context context){
        RepositorioHistorial repositorioHistorial = provideRepositorioHistorial(context);
        return new ViewModelFactory(repositorioHistorial);
    }

}
