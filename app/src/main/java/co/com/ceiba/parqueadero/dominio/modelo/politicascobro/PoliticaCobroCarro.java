package co.com.ceiba.parqueadero.dominio.modelo.politicascobro;

class PoliticaCobroCarro extends PoliticaCobro {

    private static final double VALOR_HORA = 1000;
    private static final double VALOR_DIA = 8000;


    @Override
    public double getValorDia() {
        return VALOR_DIA;
    }

    @Override
    public double getValorHora() {
        return VALOR_HORA;
    }
}
