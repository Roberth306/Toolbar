package com.germangascon.toolbar.paises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.germangascon.toolbar.R;


public class ActivityPaises extends AppCompatActivity {
    private Country[] paises;
    private ListView listView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paises);

        toolbar = findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CountryParser countryParser = new CountryParser(this);
        countryParser.parse();
        paises = countryParser.getCountries();
        CountryAdapter countryAdapter = new CountryAdapter(this, paises);
        listView = findViewById(R.id.lvCountries);
        listView.setAdapter(countryAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}
