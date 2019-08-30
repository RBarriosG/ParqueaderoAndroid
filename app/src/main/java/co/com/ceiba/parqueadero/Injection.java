package co.com.ceiba.parqueadero;

import android.content.Context;

import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioHistorial;
import co.com.ceiba.parqueadero.persistencia.BaseDeDatosParqueadero;
import co.com.ceiba.parqueadero.persistencia.entidad.HistorialImplementacion;

public class Injection {

    public static RepositorioHistorial provideRepositorioHistorial(Context context){
        BaseDeDatosParqueadero baseDeDatosParqueadero = BaseDeDatosParqueadero.getInstance(context);
        return new HistorialImplementacion(baseDeDatosParqueadero.historialDao());
    }

}
