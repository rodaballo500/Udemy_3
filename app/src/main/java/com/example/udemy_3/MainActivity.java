package com.example.udemy_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.udemy_3.FragmentosAdmin.InicioAdmin;
import com.example.udemy_3.FragmentosAdmin.ListaAdmin;
import com.example.udemy_3.FragmentosAdmin.PerfilAdmin;
import com.example.udemy_3.FragmentosAdmin.RegistrarAdmin;
import com.example.udemy_3.FragmentosCliente.AcercaDeCliente;
import com.example.udemy_3.FragmentosCliente.CompartirCliente;
import com.example.udemy_3.FragmentosCliente.InicioCliente;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null); // esto es para que los iconos(numeros) puedan tener colores y no esten en blanco  y negro

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close); // donde this esta vez no admite getAplication Contex

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // definimos fragmento por defecto (a ver si así no nos estalla
        if (savedInstanceState == null){

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new InicioCliente()).commit();
            navigationView.setCheckedItem(R.id.InicioCliente);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){ // con esto decimos que dependiendo de la opcion del menuAmin que seleccionemos se va a remplazar su fragmento correspondiente(se moistrara en pantalla)
                                    // se muestra en el framelayout de activityAdmin.xml. por esp llamamos a fragment_container_Adsmin, que es como lo llamamos

            case R.id.InicioCliente:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new InicioCliente()).commit();
                break;

            case R.id.AcercaDe:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AcercaDeCliente()).commit();
                break;

            case R.id.Compartir:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CompartirCliente()).commit();
                break;

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}