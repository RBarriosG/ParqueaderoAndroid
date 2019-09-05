package co.com.ceiba.parqueadero.ui.inyeccion.modulos;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class SystemModule {

    private final Application application;

    public SystemModule(Application application){
        this.application = application;
    }

    @Provides
    Context provideContext(){
        return application;
    }

}
