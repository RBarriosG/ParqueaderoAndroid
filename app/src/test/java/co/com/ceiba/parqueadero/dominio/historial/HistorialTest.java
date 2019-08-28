package co.com.ceiba.parqueadero.dominio.historial;

import org.junit.Test;

import co.com.ceiba.parqueadero.dominio.modelo.historial.Historial;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Vehiculo;
import co.com.ceiba.parqueadero.testdatabuilder.HistorialTestDataBuilder;
import co.com.ceiba.parqueadero.testdatabuilder.VehiculoTestDataBuilder;

import static junit.framework.TestCase.assertEquals;

public class HistorialTest {

    private static final Vehiculo VEHICULO_CARRO_PRUEBA = new VehiculoTestDataBuilder().build();

    @Test
    public void crearHistorialTest() {
        //Arrange
        HistorialTestDataBuilder historialTestDataBuilder = new HistorialTestDataBuilder();
        historialTestDataBuilder.conVehiculo(VEHICULO_CARRO_PRUEBA);
        //act
        Historial historial = historialTestDataBuilder.build();
        //assert
        assertEquals(VEHICULO_CARRO_PRUEBA, historial.getVehiculo());
    }
}
