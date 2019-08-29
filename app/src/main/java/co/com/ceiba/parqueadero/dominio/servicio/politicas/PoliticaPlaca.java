package co.com.ceiba.parqueadero.dominio.servicio.politicas;

public class PoliticaPlaca {

    private static final String REGLAS_PLACA = "a";

    public boolean empiezaPorA(String placa) {
        return placa.toLowerCase().startsWith(REGLAS_PLACA);
    }

}
