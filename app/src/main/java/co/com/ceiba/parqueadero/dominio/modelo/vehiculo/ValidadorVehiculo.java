package co.com.ceiba.parqueadero.dominio.modelo.vehiculo;

import co.com.ceiba.parqueadero.dominio.excepcion.ExcepcionValorObligaorio;
import co.com.ceiba.parqueadero.dominio.excepcion.ExepcionLongitudValor;

final class ValidadorVehiculo {

    private static final String LA_PLACA_ES_OBLIGATORIA = "La placa es obligatoria";
    private static final String LA_PLACA_DEBE_TENER_MINIMO_LETRAS = "La placa debe tener minimo letras";
    private static final String EL_CILINDRAJE_ES_OBLIGATORIO = "El cilindraje es obligatorio";

    private ValidadorVehiculo(){}

    static void validarPlaca(String placa){
        validadorObligatorio(placa);
        validadorNoVacio(placa);
    }

    static void validarCilindraje(int cilindraje, TipoVehiculo tipo){
        if(tipo == TipoVehiculo.MOTO && cilindraje <= 0){
            throw new ExcepcionValorObligaorio(EL_CILINDRAJE_ES_OBLIGATORIO);
        }
    }

    private static void validadorObligatorio(Object valor){
        if(valor == null){
            throw new ExcepcionValorObligaorio(LA_PLACA_ES_OBLIGATORIA);
        }
    }

    private static void validadorNoVacio(String valor){
        if(valor.trim().isEmpty()){
            throw new ExepcionLongitudValor(LA_PLACA_DEBE_TENER_MINIMO_LETRAS);
        }
    }

}
