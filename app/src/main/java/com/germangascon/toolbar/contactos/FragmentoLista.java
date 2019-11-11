package com.germangascon.toolbar.contactos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.germangascon.toolbar.R;


public class FragmentoLista extends Fragment {
    private ListView lvFragmento;
    private IContactoListener listener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lista, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ParserJson parserJson = new ParserJson(getActivity());
        parserJson.parse();
        lvFragmento = getView().findViewById(R.id.lvFragment);
        lvFragmento.setAdapter(new AdaptadorContactos(this, parserJson.getContactos()));

        lvFragmento.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(listener!=null) {
                    listener.onContactoSeleccionado((Contacto)lvFragmento.getAdapter().getItem(position));
                }
            }
        });

    }

    public void setContactoListener(IContactoListener listener) {
        this.listener = listener;
    }
}
