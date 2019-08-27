package co.com.ceiba.parqueadero.dominio.modelo.politicascobro;

import java.time.LocalDateTime;

import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Vehiculo;

class PoliticaCobroMoto extends PoliticaCobro {

    private static final double VALOR_HORA = 500;
    private static final double VALOR_DIA = 4000;
    private static final double VALOR_EXCEDENTE_CILINDRAJE = 2000;
    private static final int MAXIMO_CILINDRAJE = 500;
    private Vehiculo vehiculo;

    public PoliticaCobroMoto(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public double calcularCobro(LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
        double costo = super.calcularCobro(fechaIngreso, fechaSalida);
        return vehiculo.getCilindraje() > MAXIMO_CILINDRAJE ? costo + VALOR_EXCEDENTE_CILINDRAJE : costo;
    }

    @Override
    public double getValorDia() {
        return VALOR_DIA;
    }

    @Override
    public double getValorHora() {
        return VALOR_HORA;
    }
}
