package co.com.ceiba.parqueadero.dominio.servicio.politicas;

import org.junit.Test;
import org.mockito.Mockito;

import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.TipoVehiculo;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioHistorial;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.when;

public class PoliticaCupoMotoTest {

    @Test
    public void cupoDisponibleTest() {
        //arrange
        RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
        when(repositorioHistorial.contarVehiculosParqueadosPorTipo(TipoVehiculo.MOTO)).thenReturn(5L);
        PoliticaCupoMoto politicaCupoMoto = new PoliticaCupoMoto(repositorioHistorial);
        //act
        boolean cupoDisponible = politicaCupoMoto.validar();
        //assert
        assertTrue(cupoDisponible);
    }

    @Test
    public void cupoNoDisponibleTest() {
        //arrange
        RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
        when(repositorioHistorial.contarVehiculosParqueadosPorTipo(TipoVehiculo.MOTO)).thenReturn(10L);
        PoliticaCupoMoto politicaCupoMoto = new PoliticaCupoMoto(repositorioHistorial);
        //act
        boolean cupoDisponible = politicaCupoMoto.validar();
        //assert
        assertFalse(cupoDisponible);
    }

}
