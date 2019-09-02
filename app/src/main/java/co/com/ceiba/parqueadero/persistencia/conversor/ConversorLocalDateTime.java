package co.com.ceiba.parqueadero.persistencia.conversor;

import java.time.LocalDateTime;

public class ConversorLocalDateTime {

    private ConversorLocalDateTime(){}

    public static LocalDateTime aDato(String datoString){
        return datoString == null ? null : LocalDateTime.parse(datoString);
    }

    public static String aString(LocalDateTime dato){
        return dato == null ? null : dato.toString();
    }

}
