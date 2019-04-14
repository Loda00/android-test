package com.example.beginandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Reporte extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvDireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);

        this.tvNombre = (TextView) findViewById(R.id.tvNombre);
        this.tvDireccion = (TextView) findViewById(R.id.tvDireccion);

        Bundle bundle = getIntent().getExtras();

        String nombre = bundle.getString("nombreCliente");
        String direccion = bundle.getString("direccionCliente");

        this.tvNombre.setText(nombre);
        this.tvDireccion.setText(direccion);
    }
}
