package co.com.ceiba.parqueadero.dominio.modelo.vehiculo;

public class Vehiculo {

    private String placa;

    private int cilindraje;

    private TipoVehiculo tipo;

    public Vehiculo(String placa, int cilindraje, TipoVehiculo tipo) {
        ValidadorVehiculo.validarPlaca(placa);
        ValidadorVehiculo.validarCilindraje(cilindraje, tipo);
        this.placa = placa;
        this.cilindraje = cilindraje;
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }
}
