package co.com.ceiba.parqueadero.ui;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.parqueadero.R;
import co.com.ceiba.parqueadero.dominio.modelo.historial.Historial;
import co.com.ceiba.parqueadero.dominio.modelo.vehiculo.Parqueo;
import co.com.ceiba.parqueadero.ui.historiales.HistorialesViewModel;
import co.com.ceiba.parqueadero.ui.parqueado.ParqueadoViewModel;

public class Inicio extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    private static HistorialesViewModel historialesViewModel;

    public static ParqueadoViewModel parqueadoViewModel;

    private List<Historial> historiales = new ArrayList<>();

    private List<Parqueo> parqueos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewModelFactory viewModelFactory = Injection.provideViewModelFactory(this);
        historialesViewModel = new ViewModelProvider(this, viewModelFactory).get(HistorialesViewModel.class);
        parqueadoViewModel = new ViewModelProvider(this, viewModelFactory).get(ParqueadoViewModel.class);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_parqueados, R.id.nav_historial)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inicio, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public List<Historial> listarHistoriales(){
        AsyncTask.execute(() -> historiales = historialesViewModel.listar());
        Log.i("listarHistoriales", historiales.toString());
        return historiales;
    }

    public List<Parqueo> listarParqueados(){
        AsyncTask.execute(() -> parqueos = parqueadoViewModel.listarParqueados());
        Log.i("listarParqueados", parqueos.toString());
        return parqueos;
    }

}
