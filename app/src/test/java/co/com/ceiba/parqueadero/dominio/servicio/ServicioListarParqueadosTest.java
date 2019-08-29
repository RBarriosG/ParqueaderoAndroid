package co.com.ceiba.parqueadero.dominio.servicio;

import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Parqueo;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Vehiculo;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioHistorial;
import co.com.ceiba.parqueadero.testdatabuilder.VehiculoTestDataBuilder;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

public class ServicioListarParqueadosTest {

    private static final String PLACA_GENERAL = "ERF34";
    private static final int TAMANIO_REGISTRO = 12;

    @Test
    public void listarParqueadosTest() {
        //arrange
        RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
        when(repositorioHistorial.listarVehiculosEnElParqueadero()).thenReturn(crearParqueados());
        ServicioListarParqueados servicioListarParqueados = new ServicioListarParqueados(repositorioHistorial);
        //act
        List<Parqueo> parqueados = servicioListarParqueados.ejecutar();
        //assert
        assertEquals(TAMANIO_REGISTRO, parqueados.size());
    }

    private static List<Parqueo> crearParqueados() {
        List<Parqueo> registros = new ArrayList<>();
        for (int i = 0; i < ServicioListarParqueadosTest.TAMANIO_REGISTRO; i++) {
            Vehiculo vehiculo = new VehiculoTestDataBuilder().conPlaca(PLACA_GENERAL + i).build();
            LocalDateTime fechaIngreso = LocalDateTime.of(2019, 8, 29, 8, 20).plusHours(i);
            registros.add(new Parqueo(vehiculo, fechaIngreso));
        }
        return registros;
    }

}
