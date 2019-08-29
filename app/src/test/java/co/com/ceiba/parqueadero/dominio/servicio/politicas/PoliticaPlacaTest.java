package co.com.ceiba.parqueadero.dominio.servicio.politicas;

import org.junit.Test;

import co.com.ceiba.parqueadero.dominio.servicio.politicas.PoliticaPlaca;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class PoliticaPlacaTest {

    private static final String PLACA_COMIENZA_CON_A = "ABD123";
    private static final String PLACA_NO_COMIENZA_CON_A = "BDA123";

    @Test
    public void placaComienzaPorATest() {
        //arrange
        PoliticaPlaca politicaPlaca = new PoliticaPlaca();
        //act
        boolean placaComienzaConA = politicaPlaca.empiezaPorA(PLACA_COMIENZA_CON_A);
        //assert
        assertTrue(placaComienzaConA);
    }

    @Test
    public void placaNoComienzaPorATest() {
        //arrange
        PoliticaPlaca politicaPlaca = new PoliticaPlaca();
        //act
        boolean placaComienzaConA = politicaPlaca.empiezaPorA(PLACA_NO_COMIENZA_CON_A);
        //assert
        assertFalse(placaComienzaConA);
    }

}
