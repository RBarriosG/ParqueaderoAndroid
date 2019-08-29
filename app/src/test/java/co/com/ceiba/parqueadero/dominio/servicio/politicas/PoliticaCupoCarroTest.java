package co.com.ceiba.parqueadero.dominio.servicio.politicas;

import org.junit.Test;
import org.mockito.Mockito;

import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.TipoVehiculo;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioHistorial;
import co.com.ceiba.parqueadero.dominio.servicio.politicas.PoliticaCupoCarro;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.when;

public class PoliticaCupoCarroTest {

    @Test
    public void cupoDisponibleTest() {
        //arrange
        RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
        when(repositorioHistorial.contarVehiculosParqueadosPorTipo(TipoVehiculo.CARRO)).thenReturn(15l);
        PoliticaCupoCarro politicaCupoCarro = new PoliticaCupoCarro(repositorioHistorial);
        //act
        boolean cupoDisponible = politicaCupoCarro.validar();
        //assert
        assertTrue(cupoDisponible);
    }

    @Test
    public void cupoNoDisponibleTest() {
        //arrange
        RepositorioHistorial repositorioHistorial = Mockito.mock(RepositorioHistorial.class);
        when(repositorioHistorial.contarVehiculosParqueadosPorTipo(TipoVehiculo.CARRO)).thenReturn(20l);
        PoliticaCupoCarro politicaCupoCarro = new PoliticaCupoCarro(repositorioHistorial);
        //act
        boolean cupoDisponible = politicaCupoCarro.validar();
        //assert
        assertFalse(cupoDisponible);
    }

}
