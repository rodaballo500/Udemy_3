package com.example.udemy_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.udemy_3.FragmentosAdmin.InicioAdmin;
import com.example.udemy_3.FragmentosAdmin.ListaAdmin;
import com.example.udemy_3.FragmentosAdmin.PerfilAdmin;
import com.example.udemy_3.FragmentosAdmin.RegistrarAdmin;
import com.google.android.material.navigation.NavigationView;

public class MainActivityAdministrador extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
                            //implements NavigationView.OnNavigationItemSelectedListener nos sirve para poder hacer click en el menu de administrador

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_administrador);
                    // A PARTIR VIDEO 25 FINALES MINUTOS
        Toolbar toolbar = findViewById(R.id.toolbarAdmin);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout_Admin);


        NavigationView navigationView = findViewById(R.id.nav_view_Admin);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null); // esto es para que los iconos(numeros) puedan tener colores y no esten en blanco  y negro

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close); // donde this esta vez no admite getAplication Contex

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // definimos fragmento por defecto (a ver si así no nos estalla
        if (savedInstanceState == null){

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_Admin, new InicioAdmin()).commit();
            navigationView.setCheckedItem(R.id.InicioAdmin);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){ // con esto decimos que dependiendo de la opcion del menuAmin que seleccionemos se va a remplazar su fragmento correspondiente(se mostrará en pantalla)
                                     // se muestra en el framelayout de activityAdmin.xml. por esp llamamos a fragment_container_Admin, que es como lo llamamos
            case R.id.InicioAdmin:
                /*getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_Admin, new InicioAdmin()).commit();*/
                Intent intent = new Intent(MainActivityAdministrador.this, Carga.class);
                startActivity(intent);
                finish();
                break;

            case R.id.PerfilAdmin:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_Admin, new PerfilAdmin()).commit();
                break;

            case R.id.RegistrarAdmin:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_Admin, new RegistrarAdmin()).commit();
                break;

            case R.id.ListarAdmin:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_Admin, new ListaAdmin()).commit();
                break;

            case R.id.Salir:
                Toast.makeText(this, "Cerraste sesion",Toast.LENGTH_SHORT).show();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}