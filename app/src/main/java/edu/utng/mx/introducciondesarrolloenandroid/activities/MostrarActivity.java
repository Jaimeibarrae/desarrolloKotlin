package edu.utng.mx.introducciondesarrolloenandroid.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import edu.utng.mx.introducciondesarrolloenandroid.R;
import edu.utng.mx.introducciondesarrolloenandroid.clases.Usuario;
import edu.utng.mx.introducciondesarrolloenandroid.clases.daoUsuario;

public class MostrarActivity extends AppCompatActivity {
ListView lista;
daoUsuario dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        lista=(ListView)findViewById(R.id.lista);
        dao= new daoUsuario(this);
       ArrayList<Usuario> l=dao.selectUsuarios();
       ArrayList<String> list= new ArrayList<String>();

        for (Usuario u:l) {
            list.add(u.getNombre()+" "+u.getApellidos());
        }

        ArrayAdapter<String> a= new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,list);
        lista.setAdapter(a);
    }
}
