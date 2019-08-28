package co.com.ceiba.parqueadero.dominio.servicio.politicas;

import java.time.LocalDateTime;
import java.util.List;

import co.com.ceiba.parqueadero.dominio.excepcion.ExcepcionIngresoPlacaVehiculo;
import co.com.ceiba.parqueadero.dominio.excepcion.ExcepcionMaximoCupoVehiculo;
import co.com.ceiba.parqueadero.dominio.excepcion.ExcepcionVehiculoYaEstaEnParqueadero;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Parqueo;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Vehiculo;
import co.com.ceiba.parqueadero.dominio.repositorio.RepositorioHistorial;

public class PoliticaIngresoVehiculo {

    private static final String DIA_NO_HABIL_PARA_INGRESO = "Dia no habil para ingreso";
    private static final String VEHICULO_YA_ESTA_EN_EL_PARQUEADERO = "Vehiculo ya está en el parqueadero";
    private static final String CUPO_MAXIMO_DE_CARROS = "Cupo maximo de carros";
    private static final String CUPO_MAXIMO_DE_MOTOS = "Cupo maximo de motos";

    private PoliticaCupoCarro politicaCupoCarro;
    private PoliticaCupoMoto politicaCupoMoto;
    private PoliticaPlaca politicaPlaca;
    private PoliticaFecha politicaFecha;
    private RepositorioHistorial repositorioHistorial;

    public PoliticaIngresoVehiculo(RepositorioHistorial repositorioHistorial) {
        this.repositorioHistorial = repositorioHistorial;
        this.politicaCupoCarro = new PoliticaCupoCarro(repositorioHistorial);
        this.politicaCupoMoto = new PoliticaCupoMoto(repositorioHistorial);
        this.politicaPlaca = new PoliticaPlaca();
        this.politicaFecha = new PoliticaFecha();
    }

    public void validar(Vehiculo vehiculo, LocalDateTime fechaIngreso) {
        if (!validarIngresoPlacaDiaHabil(vehiculo.getPlaca(), fechaIngreso)) {
            throw new ExcepcionIngresoPlacaVehiculo(DIA_NO_HABIL_PARA_INGRESO);
        } else if (yaEstaEnParqueadero(vehiculo.getPlaca())) {
            throw new ExcepcionVehiculoYaEstaEnParqueadero(VEHICULO_YA_ESTA_EN_EL_PARQUEADERO);
        } else if (!politicaCupoCarro.validar()) {
            throw new ExcepcionMaximoCupoVehiculo(CUPO_MAXIMO_DE_CARROS);
        } else if (!politicaCupoMoto.validar()) {
            throw new ExcepcionMaximoCupoVehiculo(CUPO_MAXIMO_DE_MOTOS);
        }
    }

    private boolean yaEstaEnParqueadero(String placa) {
        return this.repositorioHistorial.obtenerHistorialActualVehiculoParqueado(placa).isPresent();
    }

    private boolean validarIngresoPlacaDiaHabil(String placa, LocalDateTime fechaIngreso) {
        return politicaFecha.esDiaHabil(fechaIngreso) && !politicaPlaca.empiezaPorA(placa);
    }

}
