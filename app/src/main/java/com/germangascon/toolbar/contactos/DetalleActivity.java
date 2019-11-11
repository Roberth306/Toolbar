package com.germangascon.toolbar.contactos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.germangascon.toolbar.R;


public class DetalleActivity extends AppCompatActivity {
    public static final String EXTRA_TEXTO = "tk.roberthramirez.EXTRA_TEXTO";
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FragmentoDetalle detalle = (FragmentoDetalle)getSupportFragmentManager().findFragmentById(R.id.frgDetalle);
        detalle.mostrarDetalle((Contacto)getIntent().getSerializableExtra(EXTRA_TEXTO));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}
