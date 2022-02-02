package com.example.udemy_3.FragmentosAdmin;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.udemy_3.R;
import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegistrarAdmin#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistrarAdmin extends Fragment {

    //DECLARAMOS VARIABLES
    TextView FechaRegistro;
    EditText Correo, Password, Nombres, Apellidos, Edad;
    Button Registrar;

    FirebaseAuth auth; // lo creas para poder crear cuenta  atraves de correo electronico

    ProgressDialog progressDialog; // esto hace que surja una pequeña animacion al momento de dar click en boton registrar



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_registrar_admin, container, false);

       // inicializamos variables
       FechaRegistro = view.findViewById(R.id.FechaRegistro);
       Correo = view.findViewById(R.id.Correo);
       Password = view.findViewById(R.id.Password);
       Nombres = view.findViewById(R.id.Nombre);
       Apellidos = view.findViewById(R.id.Apellidos);
       Edad = view.findViewById(R.id.Edad);

       Registrar = view.findViewById(R.id.Registrar);

       //CUIDAO!! HEMOS IMPORTADO CLASE Y PUEDE NO SER LA CORRECTA. hABIA DOS. COGIMOS LA PRIMERA!!
       Date date = new Date();
       SimpleDateFormat fecha = new SimpleDateFormat("d ' de 'MMM ' del ' yyyy"); // fecha del dia que toque 04/01/2022
       String SFecha = fecha.format(date); // con esto convertimos fecha a string
       FechaRegistro.setText(SFecha);

       // al hacer click en registarr

        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // convertimo a string los edit text de correo0 y contraseña para poder hacer las validaciones
               String correo = Correo.getText().toString();
               String pass = Password.getText().toString();

               // EMPIEZA LA VALIDACION DEL CORREO ELECTRONICO

                if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) { //Patterns.EMAIL_ADDRESS nos permite saber si lleva arroba y el .com
                    Correo.setError("Correo inválido");
                    Correo.setFocusable(true);// para que mantenga parpadeando la barra y pueda seguir escribiendo un correo el usuario
                }
                else if (pass.length()<6){
                    Password.setError("Contraseña debe ser mayor o igual que seis");
                    Password.setFocusable(true);
                }else {
                    RegistroAdministradores(Correo,pass);
                }
            }
        });


       return view;
    }

    // metodo para registrar administradores
    private void RegistroAdministradores(EditText correo, String pass) {

    }
}