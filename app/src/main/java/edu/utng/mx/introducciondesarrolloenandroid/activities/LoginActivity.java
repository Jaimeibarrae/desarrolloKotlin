package edu.utng.mx.introducciondesarrolloenandroid.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.utng.mx.introducciondesarrolloenandroid.R;
import edu.utng.mx.introducciondesarrolloenandroid.clases.Usuario;
import edu.utng.mx.introducciondesarrolloenandroid.clases.daoUsuario;

public class LoginActivity extends AppCompatActivity implements  View.OnClickListener{
EditText user, pass;
Button btnEntrar,btnRegistrar;
daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn = (Button) findViewById(R.id.btnEntrar);

      user=(EditText)findViewById(R.id.User);
      pass=(EditText)findViewById(R.id.Pass);
      btnEntrar=(Button)findViewById(R.id.btnEntrar);
      btnRegistrar=(Button)findViewById(R.id.btnRegistrar);

      btnEntrar.setOnClickListener(this);
      btnRegistrar.setOnClickListener(this);
    dao=new daoUsuario(this);

    }


    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnEntrar:
                    String u= user.getText().toString();
                    String p=pass.getText().toString();
                    if(u.equals("")&&p.equals("")){
                        Toast.makeText(this,"ERROR: Campos Vacios",Toast.LENGTH_LONG).show();
                    }else if(dao.login(u,p)==1){
                        Usuario ux=dao.getUsuario(u,p);
                        Toast.makeText(this,"Datos correctos",Toast.LENGTH_LONG).show();
                        Intent i2= new Intent(LoginActivity.this,AdministraUsuariosActivity.class);
                        i2.putExtra("Id",ux.getId());
                        startActivity(i2);
                    }else{
                        Toast.makeText(this,"Usuario y/o Password Incorrectos",Toast.LENGTH_LONG).show();
                    }

                    break;
                case R.id.btnRegistrar:
                        Intent i= new Intent(LoginActivity.this,RegistrarActivity.class);
                        startActivity(i);
                    break;
            }
    }
}
