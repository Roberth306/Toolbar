package com.germangascon.toolbar.contactos;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.germangascon.toolbar.R;


public class ActivityContactos extends AppCompatActivity implements IContactoListener{

    public static final String EXTRA_TEXTO= "MAIN ACTIVITY CONTACTOS";
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

        toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FragmentoLista listado = (FragmentoLista)getSupportFragmentManager().findFragmentById(R.id.frgLista);
        listado.setContactoListener(this);

    }

    @Override
    public void onContactoSeleccionado(Contacto c) {
        boolean hayDetalle =(getSupportFragmentManager().findFragmentById(R.id.frgDetalle)!=null);
        if(hayDetalle) {
            ((FragmentoDetalle)getSupportFragmentManager().findFragmentById(R.id.frgDetalle)).mostrarDetalle(c);
        }else {
            Intent i = new Intent(this, DetalleActivity.class);
            i.putExtra(DetalleActivity.EXTRA_TEXTO, c);
            startActivity(i);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}
