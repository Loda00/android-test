package com.example.beginandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etCliente, etDireccion;
    private Spinner spDistrito;
    private RadioGroup rgTipoMenu;
    private RadioButton rbMenuPobre, rbMenuEconomico, rbMenuEjecutivo;
    private CheckBox cbDescuento;
    private Button btnEnviar;

    private String nombreCliente;
    private String direccionCliente;
    private String distritoCliente;
    private String tipoMenu;
    private String menuPobre;
    private String menuEconomico;
    private String menuEjecutivo;
    private double precioMenu;
    private boolean descuento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.catchComponents();
    }

    @Override
    public void onClick(View v) {

        if (v == this.btnEnviar) {
            this.obtenerDatos();
            Intent intent = new Intent(MainActivity.this, Reporte.class);

            intent.putExtra("nombreCliente", this.getNombreCliente());
            intent.putExtra("direccionCliente", this.getDireccionCliente());
            intent.putExtra("distritoCliente", this.getDireccionCliente());
            intent.putExtra("tipoMenu", this.getTipoMenu());
            intent.putExtra("descuento", this.isDescuento());

            startActivity(intent);
        }

    }

    private void obtenerDatos(){

        this.setNombreCliente(this.etCliente.getText().toString());
        this.setDireccionCliente(this.etDireccion.getText().toString());
        this.setDistritoCliente(this.spDistrito.getSelectedItem().toString());

        switch (this.spDistrito.getSelectedItemPosition()){
            case 0:
                this.setDistritoCliente("Miraflores");
            case 1:
                this.setDistritoCliente("SJL");
            case 2:
                this.setDistritoCliente("Chorrillos");
        }

        switch (this.rgTipoMenu.getCheckedRadioButtonId()){
            case R.id.RBmenuPobre:
                this.setMenuPobre("Menú Pobre");
                this.setPrecioMenu(5);
            case R.id.RBmenuEconomico:
                this.setMenuEconomico("Menú Económico");
                this.setPrecioMenu(8);
            case R.id.RBmenuEjecutivo:
                this.setMenuEconomico("Menú Ejecutivo");
                this.setPrecioMenu(15);
        }

        this.setDescuento(this.cbDescuento.isChecked());


    }

    private void catchComponents (){
        this.etCliente = (EditText) findViewById(R.id.ETname);
        this.etDireccion = (EditText) findViewById(R.id.ETdireccion);
        this.spDistrito = (Spinner) findViewById(R.id.SPdistrito);
        this.rgTipoMenu = (RadioGroup) findViewById(R.id.RGMenus);
        this.rbMenuPobre = (RadioButton) findViewById(R.id.RBmenuPobre);
        this.rbMenuEconomico = (RadioButton) findViewById(R.id.RBmenuEconomico);
        this.rbMenuEjecutivo = (RadioButton) findViewById(R.id.RBmenuEjecutivo);
        this.cbDescuento = (CheckBox) findViewById(R.id.CHKdescuento);
        this.btnEnviar = (Button) findViewById(R.id.btnEnviar);
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getDistritoCliente() {
        return distritoCliente;
    }

    public void setDistritoCliente(String distritoCliente) {
        this.distritoCliente = distritoCliente;
    }

    public String getTipoMenu() {
        return tipoMenu;
    }

    public void setTipoMenu(String tipoMenu) {
        this.tipoMenu = tipoMenu;
    }

    public double getPrecioMenu() {
        return precioMenu;
    }

    public void setPrecioMenu(double precioMenu) {
        this.precioMenu = precioMenu;
    }

    public boolean isDescuento() {
        return descuento;
    }

    public void setDescuento(boolean descuento) {
        this.descuento = descuento;
    }

    public String getMenuPobre() {
        return menuPobre;
    }

    public void setMenuPobre(String menuPobre) {
        this.menuPobre = menuPobre;
    }

    public String getMenuEconomico() {
        return menuEconomico;
    }

    public void setMenuEconomico(String menuEconomico) {
        this.menuEconomico = menuEconomico;
    }

    public String getMenuEjecutivo() {
        return menuEjecutivo;
    }

    public void setMenuEjecutivo(String menuEjecutivo) {
        this.menuEjecutivo = menuEjecutivo;
    }
}
