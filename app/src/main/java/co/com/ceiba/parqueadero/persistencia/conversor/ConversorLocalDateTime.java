package co.com.ceiba.parqueadero.persistencia.conversor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConversorLocalDateTime {

    private ConversorLocalDateTime(){}

    private static DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    static LocalDateTime aDato(String datoString){
        return datoString == null ? null : LocalDateTime.parse(datoString);
    }

    static String aString(LocalDateTime dato){
        return dato == null ? null : dato.format(formater);
    }

}
