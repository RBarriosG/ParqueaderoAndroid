package co.com.ceiba.parqueadero.dominio.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import co.com.ceiba.parqueadero.dominio.modelo.historial.Historial;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Parqueo;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Vehiculo;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioHistorial;
import co.com.ceiba.parqueadero.testdatabuilder.HistorialTestDataBuilder;
import co.com.ceiba.parqueadero.testdatabuilder.VehiculoTestDataBuilder;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.when;

public class ServicioIngresarVehiculoTest {

    private static final LocalDateTime FECHA_INGRESO_HABIL = LocalDateTime.of(2019,8,29,8,10);

    @Test
    public void ingresarVehiculoTest() {
        //arrange
        Vehiculo vehiculo = new VehiculoTestDataBuilder().build();
        Historial historial = new HistorialTestDataBuilder().conVehiculo(vehiculo).build();
        RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
        when(repositorioHistorial.guardar(notNull())).thenReturn(historial);
        ServicioIngresarVehiculo servicioIngresarVehiculo = new ServicioIngresarVehiculo(repositorioHistorial);
        //act
        Parqueo parqueo = servicioIngresarVehiculo.ejecutar(vehiculo, FECHA_INGRESO_HABIL);
        //assert
        assertNotNull(parqueo);
    }
}
