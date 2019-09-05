package co.com.ceiba.parqueadero.ui.inyeccion.componentes;

import javax.inject.Singleton;

import co.com.ceiba.parqueadero.ui.historiales.HistorialesViewModel;
import co.com.ceiba.parqueadero.ui.inyeccion.modulos.HistorialModulo;
import co.com.ceiba.parqueadero.ui.parqueado.ParqueadoViewModel;
import dagger.Component;

@Singleton
@Component(modules = HistorialModulo.class)
public interface ComponenteGeneral {

    void inject(HistorialesViewModel historialesViewModel);
    void inject(ParqueadoViewModel parqueadoViewModel);

}
