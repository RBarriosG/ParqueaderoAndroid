package co.com.ceiba.parqueadero.persistencia.entidad;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HistorialDao {

    @Query("SELECT * FROM historial WHERE fechaSalida IS NOT NULL GROUP BY placa")
    LiveData<List<HistorialEntity>> listar();

    @Query("SELECT * FROM historial WHERE fechaSalida IS NOT NULL GROUP BY placa")
    List<HistorialEntity> listarSync();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void guardar(HistorialEntity historialEntity);

    @Query("SELECT * FROM historial WHERE fechaSalida IS NULL GROUP BY placa")
    LiveData<List<HistorialEntity>> listarVehiculosEnElParqueadero();

    @Query("SELECT * FROM historial WHERE fechaSalida IS NULL GROUP BY placa")
    List<HistorialEntity> listarVehiculosEnElParqueaderoSync();

    @Query("SELECT * FROM historial WHERE fechaSalida IS NULL AND placa LIKE :placa")
    HistorialEntity obtenerHistorialActualVehiculoParqueado(String placa);

    @Query("SELECT * FROM historial WHERE fechaSalida IS NULL AND tipo LIKE :tipo")
    long contarVehiculosParqueadosPorTipo(String tipo);

}
