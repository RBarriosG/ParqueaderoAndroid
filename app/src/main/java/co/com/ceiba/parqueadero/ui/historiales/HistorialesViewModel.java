package co.com.ceiba.parqueadero.ui.historiales;

import androidx.lifecycle.ViewModel;

import java.util.List;



import co.com.ceiba.parqueadero.dominio.modelo.historial.Historial;
import co.com.ceiba.parqueadero.dominio.servicio.ServicioListarHistorial;
import co.com.ceiba.parqueadero.ui.inyeccion.componentes.ComponenteGeneral;
import co.com.ceiba.parqueadero.ui.inyeccion.componentes.DaggerComponenteGeneral;


public class HistorialesViewModel extends ViewModel {


    ServicioListarHistorial servicioListarHistorial;

    public HistorialesViewModel() {
        ComponenteGeneral componenteHistoriales = DaggerComponenteGeneral.create();
        componenteHistoriales.inject(this);
    }


    public List<Historial> listar() {
        return servicioListarHistorial.ejecutar();
    }

}