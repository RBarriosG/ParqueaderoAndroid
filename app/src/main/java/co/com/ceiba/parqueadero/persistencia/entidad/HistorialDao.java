package co.com.ceiba.parqueadero.persistencia.entidad;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HistorialDao {

    @Query("SELECT * FROM historial WHERE fechaSalida != null GROUP BY placa")
    List<HistorialEntity> listar();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void guardar(HistorialEntity historialEntity);

    @Query("SELECT * FROM historial WHERE fechaSalida = null GROUP BY placa")
    List<HistorialEntity> listarVehiculosEnElParqueadero();

    @Query("SELECT * FROM historial WHERE fechaSalida = null AND placa LIKE :placa")
    HistorialEntity obtenerHistorialActualVehiculoParqueado(String placa);

    @Query("SELECT * FROM historial WHERE fechaSalida = null AND tipo LIKE :tipo")
    long contarVehiculosParqueadosPorTipo(String tipo);

}
