package com.germangascon.toolbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.germangascon.toolbar.contactos.ActivityContactos;
import com.germangascon.toolbar.contactos.DetalleActivity;
import com.germangascon.toolbar.paises.ActivityPaises;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Button bOcultar;
    //45
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        bOcultar = (Button) findViewById(R.id.bOcultar);
        bOcultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getSupportActionBar().isShowing()) {
                    bOcultar.setText("Mostrar barra");
                    getSupportActionBar().hide();
                } else {
                    bOcultar.setText("Ocultar barra");
                    getSupportActionBar().show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_saluda:
                Toast.makeText(this, "Hola", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(this, ActivityContactos.class);
                startActivity(i);

                return true;
            case R.id.action_countries:

                Intent o = new Intent(this, ActivityPaises.class);
                startActivity(o);
                return true;
            case R.id.action_settings:
                Toast.makeText(this, "Configuración", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
