package co.com.ceiba.parqueadero.dominio.modelo.politicascobro;

import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Optional;

import co.com.ceiba.parqueadero.dominio.excepcion.ExcepcionVehiculoNoSeEncuentraEnParqueadero;
import co.com.ceiba.parqueadero.dominio.modelo.historial.Historial;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Vehiculo;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioHistorial;
import co.com.ceiba.parqueadero.dominio.servicio.ServicioSalidaVehiculo;
import co.com.ceiba.parqueadero.testdatabuilder.HistorialTestDataBuilder;
import co.com.ceiba.parqueadero.testdatabuilder.VehiculoTestDataBuilder;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;
import static org.mockito.Mockito.when;

public class CobroCarroTest {

    private static final LocalDateTime FECHA_INGRESO_DIA_HABIL = LocalDateTime.of(2019, 8, 28, 7, 0);
    private static final LocalDateTime FECHA_SALIDA_PLUS_3_HORAS = FECHA_INGRESO_DIA_HABIL.plusHours(3);
    private static final LocalDateTime FECHA_SALIDA_PLUS_12_HORAS = FECHA_INGRESO_DIA_HABIL.plusHours(12);
    private static final LocalDateTime FECHA_SALIDA_MAS_DE_UN_DIA = FECHA_INGRESO_DIA_HABIL.plusDays(1).plusHours(5);
    private static final LocalDateTime FECHA_MENOS_DE_UNA_HORA = FECHA_INGRESO_DIA_HABIL.plusMinutes(20);

    private static final String VEHICULO_NO_ESTA_EN_PARQUEADERO = "Vehiculo no está en parqueadero";

    @Test
    public void calcularCobroMenosDe9HorasTest() {
        //arrange
        Vehiculo carro = new VehiculoTestDataBuilder().build();
        Historial historial = new HistorialTestDataBuilder().conFechaIngreso(FECHA_INGRESO_DIA_HABIL).build();
        RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
        when(repositorioHistorial.obtenerHistorialActualVehiculoParqueado(carro.getPlaca())).thenReturn(Optional.of(historial));
        ServicioSalidaVehiculo servicioSalidaVehiculo = new ServicioSalidaVehiculo(repositorioHistorial);

        //act
        double precio = servicioSalidaVehiculo.ejecutar(carro.getPlaca(), FECHA_SALIDA_PLUS_3_HORAS);

        //assert
        double precioEsperado = 3000;
        assertEquals(precioEsperado, precio, 0.001);
    }

    @Test
    public void calcularCobroMasDe9YMenorAUnDiaHorasTest() {
        //arrange
        Vehiculo carro = new VehiculoTestDataBuilder().build();
        Historial historial = new HistorialTestDataBuilder().conFechaIngreso(FECHA_INGRESO_DIA_HABIL).build();
        RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
        when(repositorioHistorial.obtenerHistorialActualVehiculoParqueado(carro.getPlaca())).thenReturn(Optional.of(historial));
        ServicioSalidaVehiculo servicioSalidaVehiculo = new ServicioSalidaVehiculo(repositorioHistorial);

        //act
        double precio = servicioSalidaVehiculo.ejecutar(carro.getPlaca(), FECHA_SALIDA_PLUS_12_HORAS);

        //assert
        double precioEsperado = 8000;
        assertEquals(precioEsperado, precio, 0.001);
    }

    @Test
    public void calcularCobroMasDeUnDiaTest() {
        //arrange
        Vehiculo carro = new VehiculoTestDataBuilder().build();
        Historial historial = new HistorialTestDataBuilder().conFechaIngreso(FECHA_INGRESO_DIA_HABIL).build();
        RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
        when(repositorioHistorial.obtenerHistorialActualVehiculoParqueado(carro.getPlaca())).thenReturn(Optional.of(historial));
        ServicioSalidaVehiculo servicioSalidaVehiculo = new ServicioSalidaVehiculo(repositorioHistorial);

        //act
        double precio = servicioSalidaVehiculo.ejecutar(carro.getPlaca(), FECHA_SALIDA_MAS_DE_UN_DIA);

        //assert
        double precioEsperado = 13000;
        assertEquals(precioEsperado, precio, 0.001);
    }

    @Test
    public void calcularCobroMenosDeUnaHoraTest() {
        //arrange
        Vehiculo carro = new VehiculoTestDataBuilder().build();
        Historial historial = new HistorialTestDataBuilder().conFechaIngreso(FECHA_INGRESO_DIA_HABIL).build();
        RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
        when(repositorioHistorial.obtenerHistorialActualVehiculoParqueado(carro.getPlaca())).thenReturn(Optional.of(historial));
        ServicioSalidaVehiculo servicioSalidaVehiculo = new ServicioSalidaVehiculo(repositorioHistorial);

        //act
        double precio = servicioSalidaVehiculo.ejecutar(carro.getPlaca(), FECHA_MENOS_DE_UNA_HORA);

        //assert
        double precioEsperado = 1000;
        assertEquals(precioEsperado, precio, 0.001);
    }

    @Test
    public void vehiculoNoEncontradoTest() {
        //arrange
        Vehiculo carro = new VehiculoTestDataBuilder().build();
        Historial historial = new HistorialTestDataBuilder().conFechaIngreso(FECHA_INGRESO_DIA_HABIL).build();
        RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
        ServicioSalidaVehiculo servicioSalidaVehiculo = new ServicioSalidaVehiculo(repositorioHistorial);

        try {
            double precio = servicioSalidaVehiculo.ejecutar(carro.getPlaca(), FECHA_SALIDA_PLUS_3_HORAS);
            fail();
        } catch (ExcepcionVehiculoNoSeEncuentraEnParqueadero e){
            //assert
            assertEquals(VEHICULO_NO_ESTA_EN_PARQUEADERO, e.getMessage());
        }


    }

}
