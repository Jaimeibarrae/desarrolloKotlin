package edu.utng.mx.introducciondesarrolloenandroid.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.usage.NetworkStatsManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import edu.utng.mx.introducciondesarrolloenandroid.R;
import edu.utng.mx.introducciondesarrolloenandroid.clases.Usuario;
import edu.utng.mx.introducciondesarrolloenandroid.clases.daoUsuario;

public class AdministraUsuariosActivity extends AppCompatActivity implements View.OnClickListener {
Button btnEditar, btnEliminar,btnMostrar,btnSalir,btnIrMenuPrincipal;
TextView nombre;
int id=0;
Usuario u;
daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administra_usuarios);
        nombre=(TextView)findViewById(R.id.nombreUsuario);
        btnEditar=(Button)findViewById(R.id.btnEditar);
        btnEliminar=(Button)findViewById(R.id.btnEliminar);
        btnMostrar=(Button)findViewById(R.id.btnMostrar);
        btnSalir=(Button)findViewById(R.id.btnSalir);
        btnIrMenuPrincipal=(Button)findViewById(R.id.btnIrMenuPrincipal);
        btnIrMenuPrincipal.setOnClickListener(this);
        btnEditar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        btnMostrar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);

        Bundle b=getIntent().getExtras();
        id=b.getInt("Id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);
        nombre.setText(u.getNombre()+" "+u.getApellidos());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnEditar:
                Intent i3 = new Intent(AdministraUsuariosActivity.this, EditarActivity.class);
                i3.putExtra("Id",id);
                startActivity(i3);
                break;
            case R.id.btnEliminar:
                AlertDialog.Builder b= new AlertDialog.Builder(this);
                b.setMessage("¿Estas seguro de eliminar tu cuenta?");
                b.setCancelable(false);
                b.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        if(dao.deleteUsuario(id)){
                            Toast.makeText(AdministraUsuariosActivity.this, "Se elimino correctamente!!!",Toast.LENGTH_LONG).show();
                            Intent i4 = new Intent(AdministraUsuariosActivity.this, LoginActivity.class);
                            startActivity(i4);
                            finish();
                        }else{
                            Toast.makeText(AdministraUsuariosActivity.this, "ERROR: No se elimino la cuenta!!!",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dialogInterface.cancel();
                    }
                });
                b.show();
                break;
            case R.id.btnMostrar:
                Intent i2 = new Intent(AdministraUsuariosActivity.this, MostrarActivity.class);
                startActivity(i2);

                break;
            case R.id.btnSalir:
                Intent i = new Intent(AdministraUsuariosActivity.this, LoginActivity.class);
                startActivity(i);
                finish();

                break;

            case R.id.btnIrMenuPrincipal:
                Intent i4 = new Intent(AdministraUsuariosActivity.this, MainActivity.class);
                startActivity(i4);

                break;
        }
    }
}
