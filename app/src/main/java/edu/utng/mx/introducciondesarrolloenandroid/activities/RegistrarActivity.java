package edu.utng.mx.introducciondesarrolloenandroid.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.utng.mx.introducciondesarrolloenandroid.R;
import edu.utng.mx.introducciondesarrolloenandroid.clases.Usuario;
import edu.utng.mx.introducciondesarrolloenandroid.clases.daoUsuario;

public class RegistrarActivity extends AppCompatActivity implements View.OnClickListener {
EditText us,pas,nom,ap;
Button reg,can;
daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        us=(EditText)findViewById(R.id.RegUser);
        pas=(EditText)findViewById(R.id.RegPass);
        nom=(EditText)findViewById(R.id.RegNombre);
        ap=(EditText)findViewById(R.id.RegApellido);
        reg=(Button)findViewById(R.id.btnRegRegistrar);
        can=(Button)findViewById(R.id.btnRegCancelar);

        can.setOnClickListener(this);
        reg.setOnClickListener(this);
        dao= new daoUsuario(this);
    }

    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnRegRegistrar:
                    Usuario u= new Usuario();
                    u.setUsuario(us.getText().toString());
                    u.setPassword(pas.getText().toString());
                    u.setNombre(nom.getText().toString());
                    u.setApellidos(ap.getText().toString());

                    if(!u.isNull()){
                        Toast.makeText(this, "ERROR Campos Vacios",Toast.LENGTH_LONG).show();

                    }else if(dao.insertUsuario(u)){
                        Toast.makeText(this, "Registro Exitoso!!!",Toast.LENGTH_LONG).show();
                        Intent i2= new Intent(RegistrarActivity.this,LoginActivity.class);
                        startActivity(i2);
                        finish();
                    }else{
                        Toast.makeText(this, "Usuario ya registrado!!!",Toast.LENGTH_LONG).show();
                    }

                    break;
                case R.id.btnRegCancelar:
                            Intent i= new Intent(RegistrarActivity.this,LoginActivity.class);
                            startActivity(i);
                            finish();
                    break;
            }
    }
}
