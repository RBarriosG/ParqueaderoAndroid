package co.com.ceiba.parqueadero.dominio.modelo.vehiculo;

import org.junit.Test;

import java.time.LocalDateTime;

import co.com.ceiba.parqueadero.testdatabuilder.ParqueoTestDataBuilder;
import co.com.ceiba.parqueadero.testdatabuilder.VehiculoTestDataBuilder;

import static junit.framework.TestCase.assertEquals;

public class ParqueoTest {

    private static final Vehiculo VEHICULO_PRUEBA = new VehiculoTestDataBuilder().build();
    private static final LocalDateTime FECHA_INGRESO_PRUEBA = LocalDateTime.of(2019, 8, 28, 7, 0);

    @Test
    public void crearParqueotTest() {
        //arrange
        ParqueoTestDataBuilder parqueoTestDataBuilder = new ParqueoTestDataBuilder();
        parqueoTestDataBuilder.conVehiculo(VEHICULO_PRUEBA)
                .conFechaIngreso(FECHA_INGRESO_PRUEBA);
        //act
        Parqueo parqueo = parqueoTestDataBuilder.build();
        //assert
        assertEquals(VEHICULO_PRUEBA, parqueo.getVehiculo());
    }
}
